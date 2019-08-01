package com.mpk.VHTees.WebApp.converters.impl;

import org.springframework.stereotype.Service;

import com.mpk.VHTees.WebApp.converters.INewsConverter;
import com.mpk.VHTees.WebApp.domains.News;
import com.mpk.VHTees.WebApp.views.ViewNews;

@Service
public class NewsConverter implements INewsConverter {

    
   
    @Override
    public News viewToDomain(ViewNews news) {
        News domain = new News();
        domain.setNewsId(news.getNewsId());
        domain.setTitle(news.getTitle());
        domain.setBody(news.getBody());
        domain.setCreatedOn(news.getCreatedOn());
        domain.setLastUpdated(news.getLastUpdated());
        domain.setNewsImg(news.getNewsImg());
        return domain;
    }

    @Override
    public ViewNews domainToView(News news) {
        ViewNews view = new ViewNews();
        view.setNewsId(news.getNewsId());
        view.setTitle(news.getTitle());
        view.setBody(news.getBody());
        view.setCreatedOn(news.getCreatedOn());
        view.setLastUpdated(news.getLastUpdated());
        view.setNewsImg(news.getNewsImg());
        return view;
    }

}
