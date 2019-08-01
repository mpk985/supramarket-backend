package com.mpk.VHTees.WebApp.accessors;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mpk.VHTees.WebApp.domains.Item;

public interface IItemAccessor extends JpaRepository<Item, Long> {
	
	//List<Item> findAllByInventoryId(Long inventoryId);

	Item findByInventoryId(Long inventoryId);

	Item findImgByInventoryId(Long inventoryId);

	List<Item> findAllByTitle(String title);

	List<Item> findAllBySize(String size);

	List<Item> findAllByInventoryRemaining(int inventoryRemaining);

	List<Item> findAllByPrice(double price);   

}
