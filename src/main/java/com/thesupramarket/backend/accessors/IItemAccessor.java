package com.thesupramarket.backend.accessors;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thesupramarket.backend.domains.Item;

public interface IItemAccessor extends JpaRepository<Item, Long> {

	/*	Find a car from car_inventory by it's unique ID	*/
	Item findByInventoryId(Long inventoryId);

	/*	List all cars whether they were sold or not	*/
//	List<Item> findAllByCarSold(String carSold);
//
//	/*	Find a car by it's VIN#	*/
//	Item findByVin(String vin);

//
//	Item findImgByInventoryId(Long inventoryId);
//

}
