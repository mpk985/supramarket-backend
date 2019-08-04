package com.thesupramarket.backend.controllers;

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


import com.thesupramarket.backend.managers.IPostManager;
import com.thesupramarket.backend.views.ViewPost;

@RestController
@RequestMapping("/api/v1/post")
public class PostControllerV1 {
    
    @Autowired
    IPostManager postManager;
    
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewPost>> getAllPosts() {
        return new ResponseEntity<>(postManager.getAllPosts(), HttpStatus.OK);
    }

    //src code from walters-bloggit-be refactor for my app
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    ResponseEntity<ViewPost> getPostsById(@PathVariable Long postId) {
            return new ResponseEntity<>(
                    postManager.getPostsById(postId), HttpStatus.OK);
        }
     



    
    // @RequestMapping(value = "/", method = RequestMethod.GET, params={ "postId" })
    // ResponseEntity<ViewPost> getPostById(@RequestParam(postId) Long postId) {
    //     return new ResponseEntity<>(postManager.getPostsById(postId), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewPost>> getPostByTitle(@PathVariable String title) {
    //     return new ResponseEntity<>(postManager.getPostsByTitle(title), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{createdOn}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewPost>> getPostByCreatedOn(@PathVariable String createdOn) {
    //     return new ResponseEntity<>(postManager.getPostsByCreatedOn(createdOn), HttpStatus.OK);
    // }
    
    // @RequestMapping(value = "/{inventoryRemaining}", method = RequestMethod.GET)
    // ResponseEntity<List<ViewPost>> getPostByInventoryRemaining(@PathVariable int inventoryRemaining) {
    //     return new ResponseEntity<>(postManager.getPostsByInventoryRemaining(inventoryRemaining), HttpStatus.OK);
    // }
    
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
   ResponseEntity<List<ViewPost>> getPostsByParams(
           @RequestParam(value = "title", required = false) String title,
           @RequestParam(value = "createdOn", required = false) Date createdOn,
           @RequestParam(value = "lastUpdated", required = false) Date lastUpdated
           ) {


       if (title != null) {
           return new ResponseEntity<>(
                   postManager.getPostsByTitle(title), HttpStatus.OK);
       } else if (createdOn != null) {
           return new ResponseEntity<>(postManager.getPostsByCreatedOn(createdOn), HttpStatus.OK);
        } else if (lastUpdated != null){
               return new ResponseEntity<>(postManager.getPostsByLastUpdated(lastUpdated), HttpStatus.OK);
           }
        else {
           return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
       }
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewPost> createPost(@RequestBody ViewPost Inventory) {
        return new ResponseEntity<>(postManager.createPost(Inventory), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    ResponseEntity<ViewPost> updatePost(@PathVariable Long postId, @RequestBody ViewPost Post) {
        return new ResponseEntity<>(postManager.updatePost(postId, Post), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewPost> deletePost(@PathVariable Long postId) {
        return new ResponseEntity<>(postManager.deletePost(postId), HttpStatus.OK);
    }
    
}
