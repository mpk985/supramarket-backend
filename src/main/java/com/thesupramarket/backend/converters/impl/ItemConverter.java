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
        domain.setMake(item.getMake());
        domain.setModel(item.getModel());
        domain.setTrim(item.getTrim());
        domain.setColor(item.getColor());
        domain.setPrice(item.getPrice());
        domain.setVin(item.getVin());
        domain.setCarSold(item.getCarSold());
        domain.setProductImg(item.getProductImg());

        return domain;
    }

    @Override
    public ViewItem domainToView(Item item) {
        ViewItem view = new ViewItem();
        view.setInventoryId(item.getInventoryId());
        view.setYear(item.getYear());
        view.setMake(item.getMake());
        view.setModel(item.getModel());
        view.setTrim(item.getTrim());
        view.setColor(item.getColor());
        view.setPrice(item.getPrice());
        view.setVin(item.getVin());
        view.setCarSold(item.getCarSold());
        view.setProductImg(item.getProductImg());

        return view;
    }

}
