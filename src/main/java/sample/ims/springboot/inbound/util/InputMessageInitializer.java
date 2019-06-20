package sample.ims.springboot.inbound.util;

import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import javax.resource.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.ims.springboot.inbound.records.InputMessage;

@Component
public class InputMessageInitializer {

  private final ImsInteractionSpecificationSetter imsInteractionSpecificationSetter;
  private final InputMessagePropertiesSetter inputMessagePropertiesSetter;

  @Autowired
  public InputMessageInitializer(
      ImsInteractionSpecificationSetter imsInteractionSpecificationSetter,
      InputMessagePropertiesSetter inputMessagePropertiesSetter) {
    this.imsInteractionSpecificationSetter = imsInteractionSpecificationSetter;
    this.inputMessagePropertiesSetter = inputMessagePropertiesSetter;
  }


  public InputMessage initInputMessage(String lastName, IMSInteractionSpec interactionSpec) {
    try {
      imsInteractionSpecificationSetter.setProperties(interactionSpec);
    } catch (ResourceException e) {
      e.printStackTrace();
    }
    InputMessage inputMessage = new InputMessage();
    inputMessagePropertiesSetter.setMessageProperties(inputMessage, lastName);
    return inputMessage;
  }
}
