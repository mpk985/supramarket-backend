package com.thesupramarket.backend.converters.impl;

import org.springframework.stereotype.Service;

import com.thesupramarket.backend.converters.IItemConverter;
import com.thesupramarket.backend.domains.Item;
import com.thesupramarket.backend.views.ViewItem;

@Service
public class ItemConverter implements IItemConverter {

    
   
    @Override
    public Item viewToDomain(ViewItem item) {
        Item domain = new Item();
        domain.setInventoryId(item.getInventoryId());
        domain.setYear(item.getYear());
        domain.setTitle(item.getTitle());
        domain.setDescription(item.getDescription());
        domain.setPrice(item.getPrice());
        domain.setSold(item.getSold());
        domain.setProductImg(item.getProductImg());

        return domain;
    }

    @Override
    public ViewItem domainToView(Item item) {
        ViewItem view = new ViewItem();
        view.setInventoryId(item.getInventoryId());
        view.setYear(item.getYear());
        view.setDescription(item.getDescription());
        view.setTitle(item.getTitle());
        view.setPrice(item.getPrice());
        view.setSold(item.getSold());
        view.setProductImg(item.getProductImg());

        return view;
    }

}
