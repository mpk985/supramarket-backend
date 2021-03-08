package com.thesupramarket.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {

	private Long id;

	private String title;

	private String bodyHtml;

    private String productType;

    private OffsetDateTime createdAt;

	private OffsetDateTime updatedAt;

    private OffsetDateTime publishedAt;

    private String status;

	@JsonProperty("variants")
    private List<ProductVariant> productVariantList;

    @JsonProperty("options")
	private List<ProductOption> productOptionList;

    @JsonProperty("images")
    private List<ProductImage> productImageList;

	public Product() {
		productVariantList = new ArrayList<>();
		productOptionList = new ArrayList<>();
		productImageList = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public OffsetDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(OffsetDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductVariant> getProductVariantList() {
		return productVariantList;
	}

	public void setProductVariantList(List<ProductVariant> productVariantList) {
		this.productVariantList = productVariantList;
	}

	public List<ProductOption> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<ProductOption> productOptionList) {
		this.productOptionList = productOptionList;
	}

	public List<ProductImage> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImage> productImageList) {
		this.productImageList = productImageList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return getId().equals(product.getId()) &&
				Objects.equals(getTitle(), product.getTitle()) &&
				Objects.equals(getBodyHtml(), product.getBodyHtml()) &&
				Objects.equals(getProductType(), product.getProductType()) &&
				Objects.equals(getCreatedAt(), product.getCreatedAt()) &&
				Objects.equals(getUpdatedAt(), product.getUpdatedAt()) &&
				Objects.equals(getPublishedAt(), product.getPublishedAt()) &&
				Objects.equals(getStatus(), product.getStatus()) &&
				Objects.equals(getProductVariantList(), product.getProductVariantList()) &&
				Objects.equals(getProductOptionList(), product.getProductOptionList()) &&
				Objects.equals(getProductImageList(), product.getProductImageList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTitle(), getBodyHtml(), getProductType(), getCreatedAt(), getUpdatedAt(), getPublishedAt(), getStatus(), getProductVariantList(), getProductOptionList(), getProductImageList());
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", title='" + title + '\'' +
				", bodyHtml='" + bodyHtml + '\'' +
				", productType='" + productType + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", publishedAt=" + publishedAt +
				", status='" + status + '\'' +
				", productVariantList=" + productVariantList +
				", productOptionList=" + productOptionList +
				", productImageList=" + productImageList +
				'}';
	}
}
