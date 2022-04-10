package com.thesupramarket.backend.service;

import com.thesupramarket.backend.domain.Product;
import com.thesupramarket.backend.domain.ProductDTO;
import com.thesupramarket.backend.domain.ProductList;
import com.thesupramarket.backend.view.ProductView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.*;

import static com.thesupramarket.backend.converter.DomainToView.convertProductToView;
import static com.thesupramarket.backend.converter.DomainToView.convertToCamelCase;

@Service
public class ShopifyService {

    public static Logger LOGGER = LogManager.getLogger(ShopifyService.class);

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

    private List<ProductView> allProducts;

    private Instant lastProductRefresh = Instant.now();

    private final long PRODUCT_REFRESH_INTERVAL_IN_MILLIS = 5000;


    /*  Query Shopify API for all Twisted Luck products      */
    public List<ProductView> getAllProducts() {
        Long start = System.currentTimeMillis();

        if(Objects.isNull(allProducts) || CollectionUtils.isEmpty(allProducts) || isItTimeToRefreshProductList()) {

            UriComponents url = UriComponentsBuilder.newInstance()
                    .scheme("https").host(shopifyHostname).path(shopifyAllProductsEndpoint).build();
            HttpEntity entity = createShopifyAuth();

            LOGGER.info("Calling Shopify Store to GET All Products with URL: {}", url);
            ResponseEntity<ProductList> responseEntity = restTemplate.exchange(
                    url.toUriString(),
                    HttpMethod.GET,
                    entity,
                    ProductList.class
            );

            List<Product> products = responseEntity.getBody().getProducts();

            LOGGER.info(products);
            if (products == null) {
                products = Collections.emptyList();
                LOGGER.info("");
            }
            LOGGER.info("TTC getAllProducts: {}ms", System.currentTimeMillis() - start);

            allProducts = convertToCamelCase(products);
            return allProducts;
        }
        LOGGER.info("Products already populated.  TTC: {}ms", System.currentTimeMillis() - start);
        return allProducts;
    }

    /*  Query Shopify API for an individual Product by its inventoryId       */
    public ProductView getProductById(Long id) {
        Long start = System.currentTimeMillis();
        ProductView pv = null;
        LOGGER.info("Call Shopify Store for Product ID");

        String idJson = id + ".json";
        UriComponents url = UriComponentsBuilder.newInstance()
                .scheme("https").host(shopifyHostname).path(shopifyAllProductsEndpoint).path(idJson).build();

        HttpEntity entity = createShopifyAuth();
        ResponseEntity<ProductDTO> responseEntity = restTemplate.exchange(
                url.toUriString(),
                HttpMethod.GET,
                entity,
                ProductDTO.class
        );

        pv = convertProductToView(responseEntity.getBody().getProduct());
        LOGGER.info("TTC getProductById: {}ms", System.currentTimeMillis() - start);
        return pv;
    }

    /*  Randomly select a Product */
    public ProductView getRandomProduct() {

        if (Objects.isNull(allProducts) || CollectionUtils.isEmpty(allProducts) || isItTimeToRefreshProductList()) {

            LOGGER.info("Call to Get a Random Product from Shopify Store");
            ProductView pv = new ProductView();
            List<ProductView> allProducts = getAllProducts();
            if (!allProducts.isEmpty() && allProducts != null) {
                int numOfProducts = allProducts.size();
                pv = allProducts.get(new Random().nextInt(numOfProducts));
            }
            return pv;
        }
        LOGGER.info("Products already available to randomize.");
        return allProducts.get(new Random().nextInt(allProducts.size()));
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

    /*  Check if time to refresh product list  */
    private boolean isItTimeToRefreshProductList(){
        Instant timeDifference = Instant.now().minusMillis(PRODUCT_REFRESH_INTERVAL_IN_MILLIS);
        return lastProductRefresh.compareTo(timeDifference) >= 0;
    }

}
