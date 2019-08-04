package com.thesupramarket.backend.converters;

import com.thesupramarket.backend.domains.News;
import com.thesupramarket.backend.views.ViewNews;

public interface INewsConverter {
    
    News viewToDomain(ViewNews news);
    
    ViewNews domainToView(News news);

}
