package com.thesupramarket.backend.domains;

import java.time.OffsetDateTime;
import java.util.List;

public class ProductImage {

    private Long id;

    private Long productId;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private String alt;

    private Integer width;

    private Integer height;

    private String imageUrl;

    private List<Long> variantIdList;

}
