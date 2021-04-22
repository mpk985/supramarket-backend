package com.thesupramarket.backend.service;

import com.thesupramarket.backend.domain.Product;
import com.thesupramarket.backend.domain.ProductDTO;
import com.thesupramarket.backend.domain.ProductList;
import com.thesupramarket.backend.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

import static com.thesupramarket.backend.converter.DomainToView.convertProductToView;
import static com.thesupramarket.backend.converter.DomainToView.convertToCamelCase;

@Service
public class ShopifyService {

    public static Logger LOGGER = LoggerFactory.getLogger(ShopifyService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${shopify.hostname}")
    private String shopifyHostname;

    @Value("${shopify.apiKey}")
    private String shopifyApiKey;

    @Value("${shopify.password}")
    private String shopifyPassword;

    @Value("${shopify.endpoint.products}")
    private String shopifyAllProductsEndpoint;

    @Value("${shopify.endpoint.product}")
    private String shopifyProductEndpoint;


    /*  Query Shopify API for all Twisted Luck products      */
    public List<ProductView> getAllProducts() {
        Long start = System.currentTimeMillis();
        String Url = "https://" + shopifyHostname + shopifyAllProductsEndpoint;
        HttpEntity entity = createShopifyAuth();

        LOGGER.info("Call to Get All Products from Shopify Store with URL: {}", Url);
        ResponseEntity<ProductList> responseEntity = restTemplate.exchange(
                Url,
                HttpMethod.GET,
                entity,
                ProductList.class
        );

        List<Product> products = responseEntity.getBody().getProducts();

        LOGGER.debug(products.toString());
        if(products == null){
            products = Collections.emptyList();
            LOGGER.info("");
        }
        return convertToCamelCase(products);
    }

    /*  Query Shopify API for an individual Product by its inventoryId       */
    public ProductView getProductById(Long id) {
        Long start = System.currentTimeMillis();
        String Url = "https://" + shopifyHostname + shopifyProductEndpoint + id + ".json";
        HttpEntity entity = createShopifyAuth();

        LOGGER.info("Call to Get All Products from Shopify Store with URL: {}", Url);
        ResponseEntity<ProductDTO> responseEntity = restTemplate.exchange(
                Url,
                HttpMethod.GET,
                entity,
                ProductDTO.class
        );
        
        ProductView pv = convertProductToView(responseEntity.getBody().getProduct());
        return pv;
    }


    private HttpEntity createShopifyAuth(){
        /*  Auth Headers for Shopify */
        String authStr = shopifyApiKey + ":" + shopifyPassword;
        byte[] authBytes = Base64.getEncoder().encode(authStr.getBytes());
        String authentication = "Basic " + new String(authBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authentication);
        HttpEntity entity = new HttpEntity(headers);

        return entity;
    }

}
