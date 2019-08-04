package com.thesupramarket.backend.managers.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.thesupramarket.backend.accessors.IPostAccessor;
import com.thesupramarket.backend.converters.IPostConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thesupramarket.backend.domains.Post;
import com.thesupramarket.backend.managers.IPostManager;
import com.thesupramarket.backend.views.ViewPost;

@Component
public class PostManager implements IPostManager {

    @Autowired
    IPostAccessor postAccessor;
    
    @Autowired
    IPostConverter postConverter;
    
    @Override
    public List<ViewPost> getAllPosts() {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost getPostsById(Long postId) {
        Post post = postAccessor.findByPostId(postId);
        if (post == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId);
        }
        return postConverter.domainToView(post);
    }

    @Override
    public ViewPost getPostImgById(Long postId) {
        Post post = postAccessor.findImgByPostId(postId);
        if (post == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId);
        }
        return postConverter.domainToView(post);
    }

    @Override
    public List<ViewPost> getPostsByTitle(String title) {
        return postAccessor.findAllByTitle(title).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewPost> getPostsByCreatedOn(Date createdOn) {
        return postAccessor.findAllByCreatedOn(createdOn).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewPost> getPostsByLastUpdated(Date lastUpdated) {
        return postAccessor.findAllByLastUpdated(lastUpdated).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }


    @Override
    public ViewPost createPost(ViewPost post) {
        return postConverter.domainToView(
                postAccessor.save(
                        postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost updatePost(Long postId, ViewPost post) {
        Post currentPost = postAccessor.findOne(postId);
        if (currentPost == null || post.getPostId() != postId) {
            return null;
        }
        return postConverter.domainToView(
                postAccessor.save(
                        postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost deletePost(Long postId) {
        Post post = postAccessor.findOne(postId);
        if (post == null) {
            return null;
        }
        postAccessor.delete(postId);
        return postConverter.domainToView(post);
    }

   

}
