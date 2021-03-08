package com.thesupramarket.backend.controller;


import com.thesupramarket.backend.domain.Product;
import com.thesupramarket.backend.service.ShopifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductControllerV1 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerV1.class);

    @Autowired
    private ShopifyService shopifyService;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        Long start = System.currentTimeMillis();
        LOGGER.info("API getAllProducts START");

        return shopifyService.getAllProducts();
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
