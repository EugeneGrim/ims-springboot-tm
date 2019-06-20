package sample.ims.springboot.inbound.service;

import com.ibm.connector2.ims.ico.IMSInteraction;
import com.ibm.connector2.ims.ico.IMSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.ims.springboot.inbound.IMSManagedConnectionFactoryProperties;
import sample.ims.springboot.inbound.exception.NotFoundException;
import sample.ims.springboot.inbound.records.InputMessage;
import sample.ims.springboot.inbound.records.OutputMessage;
import sample.ims.springboot.inbound.util.InputMessageInitializer;

@Service
public class InventoryNumberService {

  private final IMSManagedConnectionFactoryProperties imsMcfProps;
  private final InputMessageInitializer inputMessageInitializer;

  @Autowired
  public InventoryNumberService(IMSManagedConnectionFactoryProperties imsMcfProps, InputMessageInitializer inputMessageInitializer) {
    this.imsMcfProps = imsMcfProps;
    this.inputMessageInitializer = inputMessageInitializer;
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
      closeResources(connection, imsInteraction);
    }
    if (outputMessage.getOut__last__name().trim().length() <= 0) {
      throw new NotFoundException("record was not found by this name:" + lastName);
    }
    return outputMessage;
  }

  private void closeResources(Connection connection, IMSInteraction imsInteraction) {
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
