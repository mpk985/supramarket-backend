package com.thesupramarket.backend.controllers;

import java.util.List;
import java.util.Collections;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import com.thesupramarket.backend.managers.IItemManager;
import com.thesupramarket.backend.views.ViewItem;

@RestController
@RequestMapping("/api/v1/item")
public class ItemControllerV1 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ItemControllerV1.class);

    @Autowired
    IItemManager itemManager;
    

    @RequestMapping(value = "/{inventoryId}", method = RequestMethod.GET)
    ResponseEntity<ViewItem> getItemsById(@PathVariable Long inventoryId) {
        LOGGER.info("GET.itemsById for id: {}",inventoryId);

            return new ResponseEntity<>(
                    itemManager.getItemsById(inventoryId), HttpStatus.OK);
        }

//     @RequestMapping(value = "/", method = RequestMethod.GET)
//     ResponseEntity<List<ViewItem>> getItemsByCarSold(@RequestParam(name="sold", defaultValue = "false") String carSold) {
//         return new ResponseEntity<>(itemManager.getItemsByCarSold(carSold), HttpStatus.OK);
//     }
//
//     @RequestMapping(value = "/vin/{vin}", method = RequestMethod.GET)
//     ResponseEntity <ViewItem> getItemByVin(@PathVariable String vin) {
//         return new ResponseEntity<>(itemManager.getItemByVin(vin), HttpStatus.OK);
//     }

    // @RequestMapping(value = "/{size}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewItem>> getItemBySize(@PathVariable String size) {
    //     return new ResponseEntity<>(itemManager.getItemsBySize(size), HttpStatus.OK);
    // }

    // @RequestMapping(value = "/{inventoryRemaining}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewItem>> getItemByInventoryRemaining(@PathVariable int inventoryRemaining) {
    //     return new ResponseEntity<>(itemManager.getItemsByInventoryRemaining(inventoryRemaining), HttpStatus.OK);
    // }


//   @RequestMapping(value = "/", method = RequestMethod.GET)
//   ResponseEntity<List<ViewItem>> getItemsByParams(
//           @RequestParam(value = "title", required = false) String title,
//           @RequestParam(value = "size", required = false) String size,
//           @RequestParam(value = "price", required = false) Double price,
//           @RequestParam(value = "inventoryRemaining", required = false) Integer inventoryRemaining
//           ) {
//
//
//       if (title != null) {
//           return new ResponseEntity<>(
//                   itemManager.getItemsByTitle(title), HttpStatus.OK);
//       } else if (size != null) {
//           return new ResponseEntity<>(itemManager.getItemsBySize(size), HttpStatus.OK);
//        } else if (price != null){
//               return new ResponseEntity<>(itemManager.getItemsByPrice(price), HttpStatus.OK);
//           }
//        else if (inventoryRemaining != null){
//               return new ResponseEntity<>(itemManager.getItemsByInventoryRemaining(inventoryRemaining), HttpStatus.OK);
//           }
//        else {
//           return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
//       }
//    }
    
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    ResponseEntity<ViewItem> createItem(@RequestBody ViewItem Inventory) {
//        return new ResponseEntity<>(itemManager.createItem(Inventory), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/{inventoryId}", method = RequestMethod.PUT)
//    ResponseEntity<ViewItem> updateItem(@PathVariable Long inventoryId, @RequestBody ViewItem Item) {
//        return new ResponseEntity<>(itemManager.updateItem(inventoryId, Item), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/{inventoryId}", method = RequestMethod.DELETE)
//    ResponseEntity<ViewItem> deleteItem(@PathVariable Long inventoryId) {
//        return new ResponseEntity<>(itemManager.deleteItem(inventoryId), HttpStatus.OK);
//    }
    
}
