package com.thesupramarket.backend.domains;

import java.util.List;

public class ProductOption {

    private Long id;

    //Relates to the parent product bucket that all variants reside in
    private Long productId;

    private String name;

    private Integer position;

    private List<String> valuesList;

}
