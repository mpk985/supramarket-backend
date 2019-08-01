package com.mpk.VHTees.WebApp.controllers;

import java.util.List;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import com.mpk.VHTees.WebApp.managers.INewsManager;
import com.mpk.VHTees.WebApp.views.ViewNews;

@RestController
@RequestMapping("/api/v1/news")
public class NewsControllerV1 {
    
    @Autowired
    INewsManager newsManager;
    
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewNews>> getAllNews() {
        return new ResponseEntity<>(newsManager.getAllNews(), HttpStatus.OK);
    }

    //src code from walters-bloggit-be refactor for my app
    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    ResponseEntity<ViewNews> getNewsById(@PathVariable Long newsId) {
            return new ResponseEntity<>(
                    newsManager.getNewsById(newsId), HttpStatus.OK);
        }
     



    
    // @RequestMapping(value = "/", method = RequestMethod.GET, params={ "newsId" })
    // ResponseEntity<ViewNews> getNewsById(@RequestParam(newsId) Long newsId) {
    //     return new ResponseEntity<>(newsManager.getNewsById(newsId), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewNews>> getNewsByTitle(@PathVariable String title) {
    //     return new ResponseEntity<>(newsManager.getNewsByTitle(title), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{createdOn}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewNews>> getNewsByCreatedOn(@PathVariable String createdOn) {
    //     return new ResponseEntity<>(newsManager.getNewsByCreatedOn(createdOn), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{inventoryRemaining}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewNews>> getNewsByInventoryRemaining(@PathVariable int inventoryRemaining) {
    //     return new ResponseEntity<>(newsManager.getNewsByInventoryRemaining(inventoryRemaining), HttpStatus.OK);
    // }
    
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
   ResponseEntity<List<ViewNews>> getNewsByParams(
           @RequestParam(value = "title", required = false) String title,
           @RequestParam(value = "createdOn", required = false) Date createdOn,
           @RequestParam(value = "lastUpdated", required = false) Date lastUpdated
           ) {


       if (title != null) {
           return new ResponseEntity<>(
                   newsManager.getNewsByTitle(title), HttpStatus.OK);
       } else if (createdOn != null) {
           return new ResponseEntity<>(newsManager.getNewsByCreatedOn(createdOn), HttpStatus.OK);
        } else if (lastUpdated != null){
               return new ResponseEntity<>(newsManager.getNewsByLastUpdated(lastUpdated), HttpStatus.OK);
           }
        else {
           return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
       }
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewNews> createNews(@RequestBody ViewNews Inventory) {
        return new ResponseEntity<>(newsManager.createNews(Inventory), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{newsId}", method = RequestMethod.PUT)
    ResponseEntity<ViewNews> updateNews(@PathVariable Long newsId, @RequestBody ViewNews News) {
        return new ResponseEntity<>(newsManager.updateNews(newsId, News), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{newsId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewNews> deleteNews(@PathVariable Long newsId) {
        return new ResponseEntity<>(newsManager.deleteNews(newsId), HttpStatus.OK);
    }
    
}
