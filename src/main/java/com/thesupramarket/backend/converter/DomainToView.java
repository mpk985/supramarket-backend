package com.thesupramarket.backend.converter;

import com.thesupramarket.backend.domain.*;
import com.thesupramarket.backend.view.ProductVariantView;
import com.thesupramarket.backend.view.ProductView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DomainToView {

    //Convert a Domain object into a consumable for the front end
        //Convert only the snake_case properties into camelCase properties
                //camelCase = Required by Angular

    public static List<ProductView> convertToCamelCase(ProductList productList){
        if(productList.getProducts() == null) return Collections.emptyList();

        List<ProductView> list = new ArrayList<>();
        for(Product product : productList.getProducts()){
            ProductView pv = new ProductView();
            pv.setId(product.getId());
            pv.setTitle(product.getTitle());
            pv.setBodyHtml(product.getBodyHtml());
            pv.setProductType(product.getProductType());
            pv.setCreatedAt(product.getCreatedAt());
            pv.setUpdatedAt(product.getUpdatedAt());
            pv.setPublishedAt(product.getPublishedAt());
            pv.setStatus(product.getStatus());

            for(ProductVariant variant : product.getProductVariantList()){
                ProductVariantView pvv = new ProductVariantView();
                pvv.setId(variant.getId());
                pvv.setProductId(variant.getProductId());
                pvv.setTitle(variant.getTitle());
                pvv.setPrice(variant.getPrice());
                pvv.setSku(variant.getSku());
                pvv.setPosition(variant.getPosition());
                pvv.setOption1(variant.getOption1());
                pvv.setOption2(variant.getOption2());
                pvv.setOption3(variant.getOption3());
                pvv.setCreatedAt(variant.getCreatedAt());
                pvv.setUpdatedAt(variant.getUpdatedAt());
                pvv.setTaxable(variant.getTaxable());
                pvv.setImageId(variant.getImageId());
                pvv.setInventoryItemId(variant.getInventoryItemId());
                pvv.setInventoryQuantity(variant.getInventoryQuantity());
                pv.getProductVariantList().add(pvv);
            }

            for(ProductOption option : product.getProductOptionList()){

            }

            for(ProductImage image: product.getProductImageList()){

            }

            list.add(pv);
        }
        return list;
    }

}
