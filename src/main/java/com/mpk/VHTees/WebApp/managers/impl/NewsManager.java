package com.mpk.VHTees.WebApp.managers.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mpk.VHTees.WebApp.accessors.INewsAccessor;
import com.mpk.VHTees.WebApp.converters.INewsConverter;
import com.mpk.VHTees.WebApp.domains.News;
import com.mpk.VHTees.WebApp.managers.INewsManager;
import com.mpk.VHTees.WebApp.views.ViewNews;

@Component
public class NewsManager implements INewsManager {

    @Autowired
    INewsAccessor newsAccessor;
    
    @Autowired
    INewsConverter newsConverter;
    
    @Override
    public List<ViewNews> getAllNews() {
        return newsAccessor.findAll().stream()
                .map(newsConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewNews getNewsById(Long newsId) {
        News news = newsAccessor.findByNewsId(newsId);
        if (news == null) {
            throw new EntityNotFoundException("Unable to retrieve news: " + newsId);
        }
        return newsConverter.domainToView(news);
    }

    @Override
    public ViewNews getNewsImgById(Long newsId) {
        News news = newsAccessor.findImgByNewsId(newsId);
        if (news == null) {
            throw new EntityNotFoundException("Unable to retrieve news: " + newsId);
        }
        return newsConverter.domainToView(news);
    }

    @Override
    public List<ViewNews> getNewsByTitle(String title) {
        return newsAccessor.findAllByTitle(title).stream()
                .map(newsConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewNews> getNewsByCreatedOn(Date createdOn) {
        return newsAccessor.findAllByCreatedOn(createdOn).stream()
                .map(newsConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewNews> getNewsByLastUpdated(Date lastUpdated) {
        return newsAccessor.findAllByLastUpdated(lastUpdated).stream()
                .map(newsConverter::domainToView)
                .collect(Collectors.toList());
    }


    @Override
    public ViewNews createNews(ViewNews news) {
        return newsConverter.domainToView(
                newsAccessor.save(
                        newsConverter.viewToDomain(news)));
    }

    @Override
    public ViewNews updateNews(Long newsId, ViewNews news) {
        News currentNews = newsAccessor.findOne(newsId);
        if (currentNews == null || news.getNewsId() != newsId) {
            return null;
        }
        return newsConverter.domainToView(
                newsAccessor.save(
                        newsConverter.viewToDomain(news)));
    }

    @Override
    public ViewNews deleteNews(Long newsId) {
        News news = newsAccessor.findOne(newsId);
        if (news == null) {
            return null;
        }
        newsAccessor.delete(newsId);
        return newsConverter.domainToView(news);
    }

   

}
