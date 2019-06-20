package sample.ims.poolmanager;

import com.ibm.connector2.ims.ico.IMSConnectionFactory;
import com.ibm.connector2.ims.ico.IMSConnectionSpec;
import com.ibm.connector2.ims.ico.IMSInteraction;
import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import com.ibm.connector2.ims.ico.IMSManagedConnectionFactory;
import com.ibm.connector2.spi.DefaultConnectionManager;
import com.ibm.connector2.spi.DefaultConnectionPoolProperties;
import com.ibm.connector2.spi.PoolManager;
import javax.resource.cci.Connection;
import sample.ims.springboot.inbound.records.InputMessage;
import sample.ims.springboot.inbound.records.OutputMessage;
import sample.ims.springboot.inbound.util.ConnectionFactoryPropertySetter;
import sample.ims.springboot.inbound.util.ImsInteractionSpecificationSetter;
import sample.ims.springboot.inbound.util.InputMessagePropertiesSetter;
import sample.ims.springboot.inbound.util.ResourceCloser;

public class StandaloneIMSCall {

  private static Connection connection = null;
  private static IMSInteraction interaction = null;
  private static PoolManager poolManager = null;

  public static void main(String[] args) {
    try {
      IMSManagedConnectionFactory connectionFactory = new IMSManagedConnectionFactory();
      new ConnectionFactoryPropertySetter().setProperties(connectionFactory);

      DefaultConnectionPoolProperties connectionPoolProperties = new DefaultConnectionPoolProperties();
      connectionPoolProperties.setMinConnections(3);
      connectionPoolProperties.setMaxConnections(6);

      poolManager = new PoolManagerImpl();
      DefaultConnectionManager connectionManager = new DefaultConnectionManager();
      connectionManager.setConnectionPoolProperties(connectionPoolProperties);
      DefaultConnectionManager.setPoolManager(poolManager);

      IMSConnectionFactory imsConnectionFactory = (IMSConnectionFactory) connectionFactory.createConnectionFactory(connectionManager);

      IMSConnectionSpec imsConnectionSpecification = new IMSConnectionSpec();
      connection = imsConnectionFactory.getConnection(imsConnectionSpecification);

      interaction = (IMSInteraction) connection.createInteraction();
      IMSInteractionSpec interactionSpec = new IMSInteractionSpec();
      new ImsInteractionSpecificationSetter().setProperties(interactionSpec);

      InputMessage inputMessage = new InputMessage();
      String transactionParam = "LAST4";
      new InputMessagePropertiesSetter().setMessageProperties(inputMessage, transactionParam);

      OutputMessage outputMessage = new OutputMessage();
      interaction.execute(interactionSpec, inputMessage, outputMessage);

      System.out.println("Lastname: " + outputMessage.getOut__last__name());
      System.out.println("Firstname: " + outputMessage.getOut__first__name());
      System.out.println("Zipcode: " + outputMessage.getOut__zip__code());

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      new ResourceCloser().closeResources(connection, interaction);
      ((PoolManagerImpl) poolManager).stop();
    }
  }

}
