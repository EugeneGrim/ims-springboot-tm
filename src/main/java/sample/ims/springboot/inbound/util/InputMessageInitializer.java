package sample.ims.springboot.inbound.util;

import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import javax.resource.ResourceException;
import org.springframework.stereotype.Component;
import sample.ims.springboot.inbound.records.InputMessage;

@Component
public class InputMessageInitializer {

  public InputMessage initInputMessage(String lastName, IMSInteractionSpec interactionSpec) {
    try {
      interactionSpec.setInteractionVerb(IMSInteractionSpec.SYNC_SEND_RECEIVE );
      interactionSpec.setCommitMode(IMSInteractionSpec.SEND_THEN_COMMIT); //could also be set to 1, clientid is generated
      interactionSpec.setSyncLevel(IMSInteractionSpec.SYNC_LEVEL_NONE);
      interactionSpec.setExecutionTimeout(600); //how long to wait for an answer from IMS
    } catch (ResourceException e) {
      e.printStackTrace();
    }
    InputMessage inputMessage = new InputMessage();
    inputMessage.setIn__ll((short)inputMessage.getSize());
    inputMessage.setIn__zz((short)0);
    String transactionCode = "IVTNV";
    String displayCommand = "DIS";
    inputMessage.setIn__trancode(transactionCode);
    inputMessage.setIn__command(displayCommand);
    inputMessage.setIn__last__name(lastName.trim());
    return inputMessage;
  }
}
