package com.thesupramarket.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductImage {

    private Long id;

    private Long productId;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private String alt;

    private Integer width;

    private Integer height;

    @JsonProperty("src")
    private String imageUrl;

    @JsonProperty("variant_ids")
    private List<Long> variantIdList;

    public ProductImage() {
        variantIdList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Long> getVariantIdList() {
        return variantIdList;
    }

    public void setVariantIdList(List<Long> variantIdList) {
        this.variantIdList = variantIdList;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", productId=" + productId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", alt='" + alt + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", imageUrl='" + imageUrl + '\'' +
                ", variantIdList=" + variantIdList +
                '}';
    }
}
