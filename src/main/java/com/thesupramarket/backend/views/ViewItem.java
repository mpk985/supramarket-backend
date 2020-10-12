package com.thesupramarket.backend.views;

import java.util.Objects;

public class ViewItem {
    
    private Long inventoryId;
    
    private String year;
    
    private String title;
    
    private String description;

	private Double price;

	private Integer sold;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
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
		ViewItem viewItem = (ViewItem) o;
		return getInventoryId().equals(viewItem.getInventoryId()) &&
				Objects.equals(getYear(), viewItem.getYear()) &&
				Objects.equals(getTitle(), viewItem.getTitle()) &&
				Objects.equals(getDescription(), viewItem.getDescription()) &&
				Objects.equals(getPrice(), viewItem.getPrice()) &&
				Objects.equals(getSold(), viewItem.getSold()) &&
				Objects.equals(getProductImg(), viewItem.getProductImg());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInventoryId(), getYear(), getTitle(), getDescription(), getPrice(), getSold(), getProductImg());
	}

	@Override
	public String toString() {
		return "ViewItem{" +
				"inventoryId=" + inventoryId +
				", year='" + year + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", sold=" + sold +
				", productImg='" + productImg + '\'' +
				'}';
	}
}//EOF
