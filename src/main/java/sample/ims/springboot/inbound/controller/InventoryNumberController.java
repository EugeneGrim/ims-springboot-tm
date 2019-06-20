package sample.ims.springboot.inbound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.ims.springboot.inbound.records.OutputMessage;
import sample.ims.springboot.inbound.service.InventoryNumberService;

@RestController
@RequestMapping("/inventory-number")
public class InventoryNumberController {

  private final InventoryNumberService inventoryNumberService;

  @Autowired
  public InventoryNumberController(InventoryNumberService inventoryNumberService) {
    this.inventoryNumberService = inventoryNumberService;
  }

  @RequestMapping(value = "/{lastName}", method = RequestMethod.GET)
  public OutputMessage getPhonebookRecord(@PathVariable("lastName") String lastName) {
    return inventoryNumberService.getPhoneBookRecord(lastName);
  }

}

