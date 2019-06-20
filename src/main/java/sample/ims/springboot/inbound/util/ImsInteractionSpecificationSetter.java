package sample.ims.springboot.inbound.util;

import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import javax.resource.ResourceException;
import org.springframework.stereotype.Component;

@Component
public class ImsInteractionSpecificationSetter {

  public void setProperties(IMSInteractionSpec interactionSpec) throws ResourceException {
    interactionSpec.setInteractionVerb(IMSInteractionSpec.SYNC_SEND_RECEIVE);
    interactionSpec.setCommitMode(IMSInteractionSpec.SEND_THEN_COMMIT); //could also be set to 1, clientid is generated
    interactionSpec.setSyncLevel(IMSInteractionSpec.SYNC_LEVEL_NONE);
    interactionSpec.setExecutionTimeout(600); //how long to wait for an answer from IMS
  }
}
