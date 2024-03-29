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

    private final long PRODUCT_REFRESH_INTERVAL_IN_MILLIS = 300_000;


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

            LOGGER.debug(products);
            if (products == null) {
                products = Collections.emptyList();
                LOGGER.error("Product list is empty - getAllProducts");
            }
            lastProductRefresh = Instant.now();
            LOGGER.debug("Retrieved List of All Products: {}ms", System.currentTimeMillis() - start);
            LOGGER.debug("Product List Refresh Time: {}", lastProductRefresh);

            allProducts = convertToCamelCase(products);
            return allProducts;
        }
        LOGGER.debug("Products already populated. No refresh needed.");
        return allProducts;
    }

    /*  Query Shopify API for an individual Product by its inventoryId       */
    public ProductView getProductById(Long id) {
        Long start = System.currentTimeMillis();
        ProductView pv = null;
        LOGGER.debug("Call Shopify Store for Product ID");

        String idJson = id + ".json";
        UriComponents url = UriComponentsBuilder.newInstance()
                .scheme("https").host(shopifyHostname).path(shopifyProductEndpoint).path(idJson).build();

        HttpEntity entity = createShopifyAuth();
        ResponseEntity<ProductDTO> responseEntity = restTemplate.exchange(
                url.toUriString(),
                HttpMethod.GET,
                entity,
                ProductDTO.class
        );

        pv = convertProductToView(responseEntity.getBody().getProduct());
        LOGGER.debug("TTC getProductById: {}ms", System.currentTimeMillis() - start);
        return pv;
    }

    /*  Randomly select a Product */
    public ProductView getRandomProduct() {

        LOGGER.debug("Call to Get a Random Product from Shopify Store");
        ProductView pv = new ProductView();
        List<ProductView> allProducts = getAllProducts();
        if (!allProducts.isEmpty() && allProducts != null) {
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

    /*  Check if time to refresh product list  */
    private boolean isItTimeToRefreshProductList(){
        Instant newTime = Instant.now().minusMillis(PRODUCT_REFRESH_INTERVAL_IN_MILLIS);
        int result = lastProductRefresh.compareTo(newTime);
        LOGGER.debug("Last Refresh: {} ::: New Time: {} --- result: {}", lastProductRefresh, newTime,result);

        return result <= 0;
    }

}
