package com.thesupramarket.backend.domains;

import java.time.OffsetDateTime;

public class ProductVariant {

    private Long id;

    //This determines the parent Product group that all variants belong to
    private Long productId;

    private String title;

    private Double price;

    private String sku;

    private Integer position;

    private String option1;

    private String option2;

    private String option3;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private Boolean taxable;

    private Long imageId;

    private String inventoryItemId;

    private String inventoryQuantity;
}
