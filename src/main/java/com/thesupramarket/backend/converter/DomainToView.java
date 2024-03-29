package com.thesupramarket.backend.converter;

import com.thesupramarket.backend.domain.*;
import com.thesupramarket.backend.view.ProductImageView;
import com.thesupramarket.backend.view.ProductOptionView;
import com.thesupramarket.backend.view.ProductVariantView;
import com.thesupramarket.backend.view.ProductView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.thesupramarket.backend.constants.Constants.BASE_SHOPIFY_STORE_URL;
import static com.thesupramarket.backend.constants.Constants.PRODUCTS_URI;

public class DomainToView {

    //Convert a List of Domain object into a consumable for the front end
        //Convert only the snake_case properties into camelCase properties
                //camelCase = Required by Angular
    public static List<ProductView> convertToCamelCase(List<Product> productList){
        if(productList.isEmpty()) return Collections.emptyList();

        List<ProductView> list = new ArrayList<>();
        for(Product product : productList){
            ProductView pv = new ProductView();
            pv.setId(product.getId());
            pv.setTitle(product.getTitle());
            pv.setBodyHtml(product.getBodyHtml());
            pv.setProductType(product.getProductType());
            pv.setCreatedAt(product.getCreatedAt());
            pv.setUpdatedAt(product.getUpdatedAt());
            pv.setPublishedAt(product.getPublishedAt());
            pv.setStatus(product.getStatus());

            //Add the productVariantView to the ProductView, using the ProductVariant domain values
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

            //Add the productOptionView to the ProductView, using ProductOption domain values
            for(ProductOption option : product.getProductOptionList()){
                ProductOptionView pov = new ProductOptionView();
                pov.setId(option.getId());
                pov.setProductId(option.getProductId());
                pov.setName(option.getName());
                pov.setPosition(option.getPosition());
                for(String values : option.getValuesList()){
                    pov.getValuesList().add(values);
                }
                pv.getProductOptionList().add(pov);
            }

            //Add ProductImageView to the ProductView, using domain ProductImage values
            for(ProductImage image: product.getProductImageList()){
                ProductImageView piv = new ProductImageView();
                piv.setId(image.getId());
                piv.setProductId(image.getProductId());
                piv.setCreatedAt(image.getCreatedAt());
                piv.setUpdatedAt(image.getUpdatedAt());
                piv.setAlt(image.getAlt());
                piv.setWidth(image.getWidth());
                piv.setHeight(image.getHeight());
                piv.setImageUrl(image.getImageUrl());
                for(Long id : image.getVariantIdList()){
                    piv.getVariantIdList().add(id);
                }
                pv.getProductImageList().add(piv);
            }

            list.add(pv);
        }
        return list;
    }

    public static ProductView convertProductToView(Product product){
            ProductView pv = new ProductView();

            pv.setId(product.getId());
            pv.setTitle(product.getTitle());
            pv.setBodyHtml(product.getBodyHtml());
            pv.setProductType(product.getProductType());
            pv.setCreatedAt(product.getCreatedAt());
            pv.setUpdatedAt(product.getUpdatedAt());
            pv.setPublishedAt(product.getPublishedAt());
            pv.setStatus(product.getStatus());
            //Define the Product URL to the shopify store
            pv.setProductUrl(BASE_SHOPIFY_STORE_URL + PRODUCTS_URI + product.getTitle());

            //Add the productVariantView to the ProductView, using the ProductVariant domain values
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

            //Add the productOptionView to the ProductView, using ProductOption domain values
            for(ProductOption option : product.getProductOptionList()){
                ProductOptionView pov = new ProductOptionView();
                pov.setId(option.getId());
                pov.setProductId(option.getProductId());
                pov.setName(option.getName());
                pov.setPosition(option.getPosition());
                for(String values : option.getValuesList()){
                    pov.getValuesList().add(values);
                }
                pv.getProductOptionList().add(pov);
            }

            //Add ProductImageView to the ProductView, using domain ProductImage values
            for(ProductImage image: product.getProductImageList()){
                ProductImageView piv = new ProductImageView();
                piv.setId(image.getId());
                piv.setProductId(image.getProductId());
                piv.setCreatedAt(image.getCreatedAt());
                piv.setUpdatedAt(image.getUpdatedAt());
                piv.setAlt(image.getAlt());
                piv.setWidth(image.getWidth());
                piv.setHeight(image.getHeight());
                piv.setImageUrl(image.getImageUrl());
                for(Long id : image.getVariantIdList()){
                    piv.getVariantIdList().add(id);
                }
                pv.getProductImageList().add(piv);
            }

        return pv;
    }
}
