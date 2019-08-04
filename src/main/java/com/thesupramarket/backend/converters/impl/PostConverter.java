package com.thesupramarket.backend.converters.impl;

import org.springframework.stereotype.Service;

import com.thesupramarket.backend.converters.IPostConverter;
import com.thesupramarket.backend.domains.Post;
import com.thesupramarket.backend.views.ViewPost;

@Service
public class PostConverter implements IPostConverter {

    
   
    @Override
    public Post viewToDomain(ViewPost post) {
        Post domain = new Post();
        domain.setPostId(post.getPostId());
        domain.setTitle(post.getTitle());
        domain.setBody(post.getBody());
        domain.setCreatedOn(post.getCreatedOn());
        domain.setLastUpdated(post.getLastUpdated());
        domain.setPostImg(post.getPostImg());
        return domain;
    }

    @Override
    public ViewPost domainToView(Post post) {
        ViewPost view = new ViewPost();
        view.setPostId(post.getPostId());
        view.setTitle(post.getTitle());
        view.setBody(post.getBody());
        view.setCreatedOn(post.getCreatedOn());
        view.setLastUpdated(post.getLastUpdated());
        view.setPostImg(post.getPostImg());
        return view;
    }

}
