package com.mpk.VHTees.WebApp.converters.impl;

import org.springframework.stereotype.Service;

import com.mpk.VHTees.WebApp.converters.IItemConverter;
import com.mpk.VHTees.WebApp.domains.Item;
import com.mpk.VHTees.WebApp.views.ViewItem;

@Service
public class ItemConverter implements IItemConverter {

    
   
    @Override
    public Item viewToDomain(ViewItem item) {
        Item domain = new Item();
        domain.setInventoryId(item.getInventoryId());
        domain.setTitle(item.getTitle());
        domain.setSize(item.getSize());
        domain.setColor(item.getColor());
        domain.setPrice(item.getPrice());
        domain.setInventoryRemaining(item.getInventoryRemaining());
        domain.setProductImg(item.getProductImg());
        return domain;
    }

    @Override
    public ViewItem domainToView(Item item) {
        ViewItem view = new ViewItem();
        view.setInventoryId(item.getInventoryId());
        view.setTitle(item.getTitle());
        view.setSize(item.getSize());
        view.setColor(item.getColor());
        view.setPrice(item.getPrice());
        view.setInventoryRemaining(item.getInventoryRemaining());
        view.setProductImg(item.getProductImg());
        return view;
    }

}
