package com.thesupramarket.backend.controller;


import com.thesupramarket.backend.domain.Product;
import com.thesupramarket.backend.service.ShopifyService;
import com.thesupramarket.backend.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductControllerV1 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerV1.class);

    @Autowired
    private ShopifyService shopifyService;

    @RequestMapping("/products")
    public List<ProductView> getAllProducts() {
        LOGGER.info("API getAllProducts START");
        return shopifyService.getAllProducts();
    }

     @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
     ResponseEntity <ProductView> getProductById(@PathVariable Long id) {
        LOGGER.info("API getProductById START ");
         return new ResponseEntity<>(shopifyService.getProductById(id), HttpStatus.OK);
     }

     @RequestMapping(value = "/random", method = RequestMethod.GET)
     ResponseEntity<ProductView> getRandom() {
        LOGGER.info("API getRandom START");
        //Should call ALL products, then select one at random
        return new ResponseEntity<>(shopifyService.getRandomProduct(), HttpStatus.OK);
     }


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
