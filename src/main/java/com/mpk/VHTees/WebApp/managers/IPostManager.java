package com.mpk.VHTees.WebApp.managers;

import java.util.Date;
import java.util.List;

import com.mpk.VHTees.WebApp.views.ViewPost;

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
