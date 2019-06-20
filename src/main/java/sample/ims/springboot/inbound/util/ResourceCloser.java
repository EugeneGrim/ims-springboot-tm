package sample.ims.springboot.inbound.util;

import com.ibm.connector2.ims.ico.IMSInteraction;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import org.springframework.stereotype.Component;

@Component
public class ResourceCloser {

  public void closeResources(Connection connection, IMSInteraction imsInteraction) {
    try {
      if (imsInteraction != null) {
        imsInteraction.close();
      }
    } catch (ResourceException e) {
      e.printStackTrace();
    }
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (ResourceException e) {
      e.printStackTrace();
    }
  }

}
