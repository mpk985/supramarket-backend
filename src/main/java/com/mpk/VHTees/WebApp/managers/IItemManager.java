package com.mpk.VHTees.WebApp.managers;

import java.util.List;

import com.mpk.VHTees.WebApp.views.ViewItem;

public interface IItemManager {
    
    List<ViewItem> getAllItems();

    ViewItem getItemsById(Long inventoryId);

    ViewItem getItemImgById(Long inventoryId);
    
   List<ViewItem> getItemsByTitle(String title);

   List<ViewItem> getItemsBySize(String size);

   List<ViewItem> getItemsByPrice(double price);

   List<ViewItem> getItemsByInventoryRemaining(int inventoryRemaining);

   ViewItem createItem(ViewItem Item);

   ViewItem updateItem(Long inventoryId, ViewItem Item);

   ViewItem deleteItem(Long inventoryId);

}
