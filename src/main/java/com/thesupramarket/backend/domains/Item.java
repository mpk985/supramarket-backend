package com.thesupramarket.backend.domains;

// public class Item {

//}

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "car_inventory")
public class Item {

	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

	@Column(name = "year")
	private String year;

	@Column(name = "make")
	private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "trim")
    private String trim;

    @Column(name = "transmission")
    private String transmission;

	@Column(name = "color")
	private String color;

	@Column(name = "price")
	private String price;

    @Column(name = "vin")
    private String vin;

	@Column(name = "car_sold")
	private String carSold;

	@Column(name = "product_img")
	private String productImg;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVin() {
		return vin;
	}

	public String getCarSold() {
		return carSold;
	}

	public void setCarSold(String carSold) {
		this.carSold = carSold;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return getInventoryId().equals(item.getInventoryId()) &&
				Objects.equals(getYear(), item.getYear()) &&
				Objects.equals(getMake(), item.getMake()) &&
				Objects.equals(getModel(), item.getModel()) &&
				Objects.equals(getTrim(), item.getTrim()) &&
				Objects.equals(getTransmission(), item.getTransmission()) &&
				Objects.equals(getColor(), item.getColor()) &&
				Objects.equals(getPrice(), item.getPrice()) &&
				Objects.equals(getVin(), item.getVin()) &&
				Objects.equals(getCarSold(), item.getCarSold()) &&
				Objects.equals(getProductImg(), item.getProductImg());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInventoryId(), getYear(), getMake(), getModel(), getTrim(), getTransmission(), getColor(), getPrice(), getVin(), getCarSold(), getProductImg());
	}
}
