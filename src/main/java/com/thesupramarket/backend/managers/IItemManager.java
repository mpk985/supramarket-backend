package com.thesupramarket.backend.managers;

import java.util.List;

import com.thesupramarket.backend.views.ViewItem;

public interface IItemManager {

    ViewItem getItemsById(Long inventoryId);

    ViewItem getItemByVin(String vin);

    List<ViewItem> getItemsByCarSold(String carSold);

    ViewItem createItem(ViewItem Item);

    ViewItem updateItem(Long inventoryId, ViewItem Item);

    ViewItem deleteItem(Long inventoryId);

    /*  Refactored code for SupraMarket project (Legacy PunchandPi) */

//    List<ViewItem> getAllItems();

//    ViewItem getItemImgById(Long inventoryId);

//   List<ViewItem> getItemsBySize(String size);

//   List<ViewItem> getItemsByPrice(double price);

//   List<ViewItem> getItemsByInventoryRemaining(int inventoryRemaining);

}
