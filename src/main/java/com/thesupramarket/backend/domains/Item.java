package com.thesupramarket.backend.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "art_inventory")
public class Item {

	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

	@Column(name = "year")
	private String year;

	@Column(name = "title")
	private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "sold")
    private Integer sold;

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
		Item item = (Item) o;
		return getInventoryId().equals(item.getInventoryId()) &&
				Objects.equals(getYear(), item.getYear()) &&
				Objects.equals(getTitle(), item.getTitle()) &&
				Objects.equals(getDescription(), item.getDescription()) &&
				Objects.equals(getPrice(), item.getPrice()) &&
				Objects.equals(getSold(), item.getSold()) &&
				Objects.equals(getProductImg(), item.getProductImg());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInventoryId(), getYear(), getTitle(), getDescription(), getPrice(), getSold(), getProductImg());
	}
}
