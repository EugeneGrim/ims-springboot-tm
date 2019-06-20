package sample.ims.springboot.inbound.util;

import org.springframework.stereotype.Component;
import sample.ims.springboot.inbound.records.InputMessage;

@Component
public class InputMessagePropertiesSetter {

  public void setMessageProperties(InputMessage inputMessage, String param) {
    inputMessage.setIn__ll((short) inputMessage.getSize());
    inputMessage.setIn__zz((short) 0);
    final String transactionCode = "IVTNV";
    final String command = "DIS";
    inputMessage.setIn__trancode(transactionCode);
    inputMessage.setIn__command(command);
    inputMessage.setIn__last__name(param);
  }
}
