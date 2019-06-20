package sample.ims.springboot.inbound.util;

import com.ibm.connector2.ims.ico.IMSManagedConnectionFactory;
import javax.resource.ResourceException;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactoryPropertySetter {

  public void setProperties(IMSManagedConnectionFactory connectionFactory) throws ResourceException {
    String password = "SYS2";
    String hostName = "192.86.32.29";//IMS Connect Ip-address or hostname
    Integer portNumber = 9999;//IMS Connect Portnumber
    String dataStoreName = "IMS1";//IMS Connect Data Store
    Boolean sslEnabled = Boolean.FALSE;//turn off SSL
    String userName = "EPAM006";//Userid
    connectionFactory.setHostName(hostName);
    connectionFactory.setDataStoreName(dataStoreName);
    connectionFactory.setPortNumber(portNumber);
    connectionFactory.setSSLEnabled(sslEnabled);
    connectionFactory.setUserName(userName);
    connectionFactory.setPassword(password);
  }
}
