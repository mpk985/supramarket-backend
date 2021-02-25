package com.thesupramarket.backend.service;

import com.thesupramarket.backend.domains.Product;
import com.thesupramarket.backend.domains.ProductList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

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
    private String shopifyProductEndpoint;

    public List<Product> getAllProducts() {
        Long start = System.currentTimeMillis();
        String authStr = shopifyApiKey + ":" + shopifyPassword;
        byte[] authBytes = Base64.getEncoder().encode(authStr.getBytes());
        String authentication = "Basic " + new String(authBytes);

        String Url = "https://" + shopifyHostname + shopifyProductEndpoint;
        LOGGER.info("Call to Get All Products from Shopify Store with URL: {}", Url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authentication);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<ProductList> responseEntity = restTemplate.exchange(
                Url,
                HttpMethod.GET,
                entity,
                ProductList.class
        );

//        String response = responseEntity.getBody();

        List<Product> products = responseEntity.getBody().getProducts();

        LOGGER.info(products.toString());
        return products;
    }
}
