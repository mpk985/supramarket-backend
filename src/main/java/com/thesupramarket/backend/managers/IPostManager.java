package com.thesupramarket.backend.managers;

import java.util.Date;
import java.util.List;

import com.thesupramarket.backend.views.ViewPost;

public interface IPostManager {
    
    List<ViewPost> getAllPosts();

    ViewPost getPostsById(Long postId);

    ViewPost getPostImgById(Long postId);
    
   List<ViewPost> getPostsByTitle(String title);

   List<ViewPost> getPostsByCreatedOn(Date createdOn);

   List<ViewPost> getPostsByLastUpdated(Date lastUpdated);

   ViewPost createPost(ViewPost Post);

   ViewPost updatePost(Long postId, ViewPost Post);

   ViewPost deletePost(Long postId);

}
