package sample.ims.springboot.inbound.util;

import javax.annotation.PreDestroy;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ibm.connector2.ims.ico.IMSConnectionFactory;
import com.ibm.connector2.ims.ico.IMSConnectionSpec;
import com.ibm.connector2.ims.ico.IMSManagedConnectionFactory;
import com.ibm.connector2.spi.DefaultConnectionManager;
import com.ibm.connector2.spi.DefaultConnectionPoolProperties;
import com.ibm.connector2.spi.PoolManager;

import sample.ims.poolmanager.PoolManagerImpl;

@Component
@ConfigurationProperties("imsmcf")
@Getter
@Setter
public class IMSManagedConnectionFactoryProperties {

  private String hostname;
  private String datastorename;
  private Integer portnumber;
  private String username;
  private String password;

  @Value("${imsmcf.sslenabled ?: false}")
  private Boolean sslenabled;

  private Boolean connectionpoolenabled;

  @Value("${imsmcf.minconnections ?: 1}")
  private Integer minconnections;

  @Value("${imsmcf.maxconnections ?: 5}")
  private Integer maxconnections;

  private PoolManager poolManager = null;
  private IMSConnectionFactory imsConnectionFactory = null;
  private IMSConnectionSpec imsConnectionSpecification = null;
  private IMSManagedConnectionFactory connectionFactory = null;

  public Connection getIMSConnection(String username, String password) throws ResourceException {
    if (connectionFactory == null) {
      connectionFactory = new IMSManagedConnectionFactory();
      connectionFactory.setHostName(this.hostname);
      connectionFactory.setDataStoreName(this.datastorename);
      connectionFactory.setPortNumber(this.portnumber);
      connectionFactory.setUserName(this.username);
      connectionFactory.setPassword(this.password);
      connectionFactory.setSSLEnabled(this.sslenabled);
      if (connectionpoolenabled) {
        DefaultConnectionPoolProperties connPoolProps = new DefaultConnectionPoolProperties();
        connPoolProps.setMinConnections(minconnections);
        connPoolProps.setMaxConnections(maxconnections);
        poolManager = new PoolManagerImpl();
        DefaultConnectionManager connMgr = new DefaultConnectionManager();
        connMgr.setConnectionPoolProperties(connPoolProps);
        DefaultConnectionManager.setPoolManager(poolManager);
        imsConnectionFactory = (IMSConnectionFactory) connectionFactory.createConnectionFactory(connMgr);
      } else {
        imsConnectionFactory = (IMSConnectionFactory) connectionFactory.createConnectionFactory();
      }
      imsConnectionSpecification = new IMSConnectionSpec();
    }
    imsConnectionSpecification.setUserName(username);
    imsConnectionSpecification.setPassword(password);
    return imsConnectionFactory.getConnection(imsConnectionSpecification);
  }

  @PreDestroy
  public void destroy() {
    if (poolManager != null) {
      ((PoolManagerImpl) poolManager).stop();
    }
  }
}