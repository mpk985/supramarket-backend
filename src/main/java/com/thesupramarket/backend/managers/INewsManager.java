package com.thesupramarket.backend.managers;

import java.util.Date;
import java.util.List;

import com.thesupramarket.backend.views.ViewNews;

public interface INewsManager {
    
    List<ViewNews> getAllNews();

    ViewNews getNewsById(Long newsId);

    ViewNews getNewsImgById(Long newsId);
    
   List<ViewNews> getNewsByTitle(String title);

   List<ViewNews> getNewsByCreatedOn(Date createdOn);

   List<ViewNews> getNewsByLastUpdated(Date lastUpdated);

   ViewNews createNews(ViewNews News);

   ViewNews updateNews(Long newsId, ViewNews News);

   ViewNews deleteNews(Long newsId);

}
