package com.mpk.VHTees.WebApp.converters;

import com.mpk.VHTees.WebApp.domains.Post;
import com.mpk.VHTees.WebApp.views.ViewPost;

public interface IPostConverter {
    
    Post viewToDomain(ViewPost post);
    
    ViewPost domainToView(Post post);

}
