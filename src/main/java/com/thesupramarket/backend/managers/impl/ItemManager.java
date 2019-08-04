package com.thesupramarket.backend.managers.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.thesupramarket.backend.accessors.IItemAccessor;
import com.thesupramarket.backend.converters.IItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thesupramarket.backend.domains.Item;
import com.thesupramarket.backend.managers.IItemManager;
import com.thesupramarket.backend.views.ViewItem;

@Component
public class ItemManager implements IItemManager {

    @Autowired
    IItemAccessor itemAccessor;
    
    @Autowired
    IItemConverter itemConverter;
    
//    @Override
//    public List<ViewItem> getAllItems() {
//        return itemAccessor.findAll().stream()
//                .map(itemConverter::domainToView)
//                .collect(Collectors.toList());
//    }

    @Override
    public ViewItem getItemsById(Long inventoryId) {
        Item item = itemAccessor.findByInventoryId(inventoryId);
        if (item == null) {
            throw new EntityNotFoundException("ItemManager: Can Not Find Item #: " + inventoryId);
        }
        return itemConverter.domainToView(item);
    }

//    @Override
//    public ViewItem getItemImgById(Long inventoryId) {
//        Item item = itemAccessor.findImgByInventoryId(inventoryId);
//        if (item == null) {
//            throw new EntityNotFoundException("Unable to retrieve inventory item: " + inventoryId);
//        }
//        return itemConverter.domainToView(item);
//    }

    @Override
    public ViewItem getItemByVin(String vin) {
        return itemConverter.domainToView(itemAccessor.findByVin(vin));
    }

    @Override
    public List<ViewItem> getItemsByCarSold(String carSold) {
        return itemAccessor.findAllByCarSold(carSold).stream()
                .map(itemConverter::domainToView)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ViewItem> getItemsByPrice(double price) {
//        return itemAccessor.findAllByPrice(price).stream()
//                .map(itemConverter::domainToView)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ViewItem> getItemsByInventoryRemaining(int inventoryRemaining) {
//        return itemAccessor.findAllByInventoryRemaining(inventoryRemaining).stream()
//                .map(itemConverter::domainToView)
//                .collect(Collectors.toList());
//    }

    @Override
    public ViewItem createItem(ViewItem item) {
        return itemConverter.domainToView(
                itemAccessor.save(
                        itemConverter.viewToDomain(item)));
    }

    @Override
    public ViewItem updateItem(Long inventoryId, ViewItem item) {
        Item currentItem = itemAccessor.findOne(inventoryId);
        if (currentItem == null || item.getInventoryId() != inventoryId) {
            return null;
        }
        return itemConverter.domainToView(
                itemAccessor.save(
                        itemConverter.viewToDomain(item)));
    }

    @Override
    public ViewItem deleteItem(Long inventoryId) {
        Item item = itemAccessor.findOne(inventoryId);
        if (item == null) {
            return null;
        }
        itemAccessor.delete(inventoryId);
        return itemConverter.domainToView(item);
    }

   

}
