package com.thesupramarket.backend.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thesupramarket.backend.domain.Product;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class ProductView {

    private Long id;

    private String title;

    private String bodyHtml;

    private String productType;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private OffsetDateTime publishedAt;

    private String status;

    private List<ProductVariantView> productVariantList;

    private List<ProductOptionView> productOptionList;

    private List<ProductImageView> productImageList;

    private String productUrl;

    public ProductView() {
        productVariantList = new ArrayList<ProductVariantView>();
        productOptionList = new ArrayList<ProductOptionView>();
        productImageList = new ArrayList<ProductImageView>();
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

    public List<ProductVariantView> getProductVariantList() {
        return productVariantList;
    }

    public void setProductVariantList(List<ProductVariantView> productVariantList) {
        this.productVariantList = productVariantList;
    }

    public List<ProductOptionView> getProductOptionList() {
        return productOptionList;
    }

    public void setProductOptionList(List<ProductOptionView> productOptionList) {
        this.productOptionList = productOptionList;
    }

    public List<ProductImageView> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImageView> productImageList) {
        this.productImageList = productImageList;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Override
    public String toString() {
        return "ProductView{" +
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
                ", productUrl='" + productUrl + '\'' +
                '}';
    }
}
