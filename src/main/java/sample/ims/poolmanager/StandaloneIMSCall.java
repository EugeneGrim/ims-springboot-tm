package sample.ims.poolmanager;

import com.ibm.connector2.ims.ico.IMSConnectionFactory;
import com.ibm.connector2.ims.ico.IMSConnectionSpec;
import com.ibm.connector2.ims.ico.IMSInteraction;
import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import com.ibm.connector2.ims.ico.IMSManagedConnectionFactory;
import com.ibm.connector2.ims.ico.IMSResourceAdapter;
import com.ibm.connector2.spi.DefaultConnectionManager;
import com.ibm.connector2.spi.DefaultConnectionPoolProperties;
import com.ibm.connector2.spi.PoolManager;
import com.ibm.j2ca.extension.logging.LogUtils;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import sample.ims.springboot.inbound.records.InputMessage;
import sample.ims.springboot.inbound.records.OutputMessage;

public class StandaloneIMSCall {

  private static Connection connection = null;
  private static IMSInteraction interaction = null;
  private static PoolManager poolManager = null;

  public static void main(String[] args) {
    try {
      //create managed connection factory
      IMSManagedConnectionFactory connectionFactory = new IMSManagedConnectionFactory();
      //properties values for accessing IMS using IMS Connect
      String password = "SYS2";
      String hostName = "192.86.32.29";//IMS Connect Ip-address or hostname
      Integer portNumber = 9999;//IMS Connect Portnumber
      String dataStoreName = "IMS1";//IMS Connect Data Store
      Boolean sslEnabled = Boolean.FALSE;//turn off SSL
      String userName = "EPAM006";//Userid
      //Create LogUtil
      LogUtils logUtils = new LogUtils(new IMSResourceAdapter(), true);
      //turn on logging if required
      //logUtils.setLogger(universalLogger);

      //Set Managed Connection Factory Properties
      connectionFactory.setHostName(hostName);
      connectionFactory.setDataStoreName(dataStoreName);
      connectionFactory.setPortNumber(portNumber);
      //connectionFactory.setLogWriter(logWriter);
      connectionFactory.setSSLEnabled(sslEnabled);
      connectionFactory.setUserName(userName);
      connectionFactory.setPassword(password);
      //turn on logging if required
      connectionFactory.setLogUtil(logUtils);

      //create DefaultPoolManagerProperties
      DefaultConnectionPoolProperties connectionPoolProperties = new DefaultConnectionPoolProperties();
      connectionPoolProperties.setMinConnections(3);
      connectionPoolProperties.setMaxConnections(6);

      //Create PoolManager
      poolManager = new PoolManagerImpl();

      //Create DefaultConnectionManager
      DefaultConnectionManager connectionManager = new DefaultConnectionManager();
      connectionManager.setConnectionPoolProperties(connectionPoolProperties);
      //connectionManager.setLogWriter(logWriter);
      DefaultConnectionManager.setPoolManager(poolManager);

      //create ConnectionFactory
      IMSConnectionFactory imsConnectionFactory = (IMSConnectionFactory) connectionFactory.createConnectionFactory(connectionManager);

      //create IMS Connection Spec
      IMSConnectionSpec imsConnectionSpecification = new IMSConnectionSpec();

      //create Connection
      connection = imsConnectionFactory.getConnection(imsConnectionSpecification);

      //create Interaction
      interaction = (IMSInteraction) connection.createInteraction();

      //create and fill Interaction specification
      IMSInteractionSpec interactionSpec = new IMSInteractionSpec();
      interactionSpec.setInteractionVerb(IMSInteractionSpec.SYNC_SEND_RECEIVE);
      interactionSpec.setCommitMode(IMSInteractionSpec.SEND_THEN_COMMIT); //could also be set to 1, clientid is generated
      interactionSpec.setSyncLevel(IMSInteractionSpec.SYNC_LEVEL_NONE);
      interactionSpec.setExecutionTimeout(600); //how long to wait for an answer from IMS

      //prepare Input Message
      InputMessage inputMessage = new InputMessage();
      inputMessage.setIn__ll((short) inputMessage.getSize());
      inputMessage.setIn__zz((short) 0);
      inputMessage.setIn__trancode("IVTNV");
      inputMessage.setIn__command("DIS");
      inputMessage.setIn__last__name("LAST4");

      //prepare Output Message
      OutputMessage outputMessage = new OutputMessage();

      //return code
      interaction.execute(interactionSpec, inputMessage, outputMessage);
      //check for async output only useful for CM 0 interactions
      //System.out.println(interactionSpec.getAsyncOutputAvailable());
      //display the output with getter methods
      System.out.println("Lastname: " + outputMessage.getOut__last__name());
      System.out.println("Firstname: " + outputMessage.getOut__first__name());
      System.out.println("Zipcode: " + outputMessage.getOut__zip__code());

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //close
      try {
        if (interaction != null) {
          interaction.close();
        }
      } catch (ResourceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (ResourceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      //cleanup all connection still in the pool
      ((PoolManagerImpl) poolManager).stop();
    }
  }
}
