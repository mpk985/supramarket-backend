package com.mpk.VHTees.WebApp.domains;

// public class Item {

//}

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothing_inventory")
public class Item {

	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

	@Column(name = "title")
	private String title;

	@Column(name = "size")
	private String size;

	@Column(name = "color")
	private String color;

	@Column(name = "price")
	private double price;

	@Column(name = "inventory_remaining")
	private int inventoryRemaining;

	@Column(name = "product_img")
	private String productImg;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventoryRemaining() {
		return inventoryRemaining;
	}

	public void setInventoryRemaining(int inventoryRemaining) {
		this.inventoryRemaining = inventoryRemaining;
	}

	public String getProductImg(){
		return productImg;
	}

	public void setProductImg(String productImg){
		this.productImg = productImg;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result + inventoryRemaining;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productImg == null) ? 0 : productImg.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		if (inventoryRemaining != other.inventoryRemaining)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productImg == null) {
			if (other.productImg != null)
				return false;
		} else if (!productImg.equals(other.productImg))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [inventoryId=" + inventoryId + ", title=" + title + ", size=" + size + ", color=" + color
				+ ", price=" + price + ", inventoryRemaining=" + inventoryRemaining + ", productImg=" + productImg
				+ "]";
	}

}
