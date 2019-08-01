package com.mpk.VHTees.WebApp.converters;

import com.mpk.VHTees.WebApp.domains.Item;
import com.mpk.VHTees.WebApp.views.ViewItem;

public interface IItemConverter {
    
    Item viewToDomain(ViewItem item);
    
    ViewItem domainToView(Item item);

}
