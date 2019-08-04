package com.thesupramarket.backend.converters;

import com.thesupramarket.backend.domains.Post;
import com.thesupramarket.backend.views.ViewPost;

public interface IPostConverter {
    
    Post viewToDomain(ViewPost post);
    
    ViewPost domainToView(Post post);

}
