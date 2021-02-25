package com.thesupramarket.backend.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ProductOption {

    private Long id;

    //Relates to the parent product bucket that all variants reside in
    @JsonProperty("product_id")
    private Long productId;

    private String name;

    private Integer position;

    @JsonProperty("values")
    private List<String> valuesList;

    public ProductOption() {
        this.valuesList = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<String> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<String> valuesList) {
        this.valuesList = valuesList;
    }

    @Override
    public String toString() {
        return "ProductOption{" +
                "id=" + id +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", valuesList=" + valuesList +
                '}';
    }
}
