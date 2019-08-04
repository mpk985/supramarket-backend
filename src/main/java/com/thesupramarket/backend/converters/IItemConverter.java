package com.thesupramarket.backend.converters;

import com.thesupramarket.backend.domains.Item;
import com.thesupramarket.backend.views.ViewItem;

public interface IItemConverter {
    
    Item viewToDomain(ViewItem item);
    
    ViewItem domainToView(Item item);

}
