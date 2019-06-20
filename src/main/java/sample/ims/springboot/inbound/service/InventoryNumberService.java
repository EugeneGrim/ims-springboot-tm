package sample.ims.springboot.inbound.service;

import com.ibm.connector2.ims.ico.IMSInteraction;
import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import javax.resource.cci.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.ims.springboot.inbound.util.IMSManagedConnectionFactoryProperties;
import sample.ims.springboot.inbound.exception.NotFoundException;
import sample.ims.springboot.inbound.records.InputMessage;
import sample.ims.springboot.inbound.records.OutputMessage;
import sample.ims.springboot.inbound.util.InputMessageInitializer;
import sample.ims.springboot.inbound.util.ResourceCloser;

@Service
public class InventoryNumberService {

  private final IMSManagedConnectionFactoryProperties imsMcfProps;
  private final InputMessageInitializer inputMessageInitializer;
  private final ResourceCloser resourceCloser;

  @Autowired
  public InventoryNumberService(IMSManagedConnectionFactoryProperties imsMcfProps,
      InputMessageInitializer inputMessageInitializer,
      ResourceCloser resourceCloser) {
    this.imsMcfProps = imsMcfProps;
    this.inputMessageInitializer = inputMessageInitializer;
    this.resourceCloser = resourceCloser;
  }

  public OutputMessage getPhoneBookRecord(String lastName) {
    OutputMessage outputMessage = new OutputMessage();
    //never make this global, then different threads use the same connection and imsInteraction
    Connection connection = null;
    IMSInteraction imsInteraction = null;
    IMSInteractionSpec imsInteractionSpecification = new IMSInteractionSpec();
    try {
      connection = imsMcfProps.getIMSConnection(null, null);
      imsInteraction = (IMSInteraction)connection.createInteraction();
      InputMessage inputMessage = inputMessageInitializer.initInputMessage(lastName, imsInteractionSpecification);
      imsInteraction.execute(imsInteractionSpecification, inputMessage, outputMessage);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      resourceCloser.closeResources(connection, imsInteraction);
    }
    if (outputMessage.getOut__last__name().trim().length() <= 0) {
      throw new NotFoundException("record was not found by this name:" + lastName);
    }
    return outputMessage;
  }
}
