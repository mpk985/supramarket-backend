package com.mpk.VHTees.WebApp.converters;

import com.mpk.VHTees.WebApp.domains.News;
import com.mpk.VHTees.WebApp.views.ViewNews;

public interface INewsConverter {
    
    News viewToDomain(ViewNews news);
    
    ViewNews domainToView(News news);

}
