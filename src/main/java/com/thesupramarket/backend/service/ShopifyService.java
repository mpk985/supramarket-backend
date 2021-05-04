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
import java.util.Random;

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
        LOGGER.info("TTC getAllProducts: {}ms", System.currentTimeMillis() - start);
        return convertToCamelCase(products);
    }

    /*  Query Shopify API for an individual Product by its inventoryId       */
    public ProductView getProductById(Long id) {
        Long start = System.currentTimeMillis();
        LOGGER.info("Call to Get All Products from Shopify Store");
        String Url = "https://" + shopifyHostname + shopifyProductEndpoint + id + ".json";
        HttpEntity entity = createShopifyAuth();
        ResponseEntity<ProductDTO> responseEntity = restTemplate.exchange(
                Url,
                HttpMethod.GET,
                entity,
                ProductDTO.class
        );

        ProductView pv = convertProductToView(responseEntity.getBody().getProduct());
        LOGGER.info("TTC getProductById: {}ms", System.currentTimeMillis() - start);
        return pv;
    }

    /*  Randomly select a Product */
    public ProductView getRandomProduct() {
        LOGGER.info("Call to Get a Random Product from Shopify Store");
        ProductView pv = new ProductView();
        List<ProductView> allProducts= getAllProducts();
        if(!allProducts.isEmpty() && allProducts != null){
            int numOfProducts = allProducts.size();
            pv = allProducts.get(new Random().nextInt(numOfProducts));
        }
        return pv;
    }
    
    /*  Auth Headers for Shopify */
    private HttpEntity createShopifyAuth(){
        String authStr = shopifyApiKey + ":" + shopifyPassword;
        byte[] authBytes = Base64.getEncoder().encode(authStr.getBytes());
        String authentication = "Basic " + new String(authBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authentication);
        HttpEntity entity = new HttpEntity(headers);

        return entity;
    }

}
