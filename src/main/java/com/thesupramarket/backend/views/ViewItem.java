package com.thesupramarket.backend.views;

import java.util.Objects;

public class ViewItem {
    
    private Long inventoryId;
    
    private String year;
    
    private String make;
    
    private String model;
    
    private String trim;
    
    private String transmission;

	private String color;

	private String price;

	private String vin;

	private String carSold;

	private String productImg;
//
//	public ViewItem(Long inventoryId, String year, String make, String model, String trim, String transmission, String color, String price, String vin, String carSold, String productImg) {
//		this.inventoryId = inventoryId;
//		this.year = year;
//		this.make = make;
//		this.model = model;
//		this.trim = trim;
//		this.transmission = transmission;
//		this.color = color;
//		this.price = price;
//		this.vin = vin;
//		this.carSold = carSold;
//		this.productImg = productImg;
//	}

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

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCarSold() {
		return carSold;
	}

	public void setCarSold(String carSold) {
		this.carSold = carSold;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ViewItem viewItem = (ViewItem) o;
		return getInventoryId().equals(viewItem.getInventoryId()) &&
				Objects.equals(getYear(), viewItem.getYear()) &&
				Objects.equals(getMake(), viewItem.getMake()) &&
				Objects.equals(getModel(), viewItem.getModel()) &&
				Objects.equals(getTrim(), viewItem.getTrim()) &&
				Objects.equals(getTransmission(), viewItem.getTransmission()) &&
				Objects.equals(getColor(), viewItem.getColor()) &&
				Objects.equals(getPrice(), viewItem.getPrice()) &&
				Objects.equals(getVin(), viewItem.getVin()) &&
				Objects.equals(getCarSold(), viewItem.getCarSold()) &&
				Objects.equals(getProductImg(), viewItem.getProductImg());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInventoryId(), getYear(), getMake(), getModel(), getTrim(), getTransmission(), getColor(), getPrice(), getVin(), getCarSold(), getProductImg());
	}
}//EOF
