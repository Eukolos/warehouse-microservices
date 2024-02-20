package com.istanify.warehouse.configuration;

import com.istanify.warehouse.client.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class BeanConfig {
//   public static final String PRODUCT_SERVICE_URL = "http://product-service:8080";
    public static final String PRODUCT_SERVICE_URL = "http://localhost:8080";
    public static final String PRODUCT_SERVICE_PATH = "/api/v1/products";
    @Bean
    ProductClient ProductClient() {
        RestClient client = RestClient.create(PRODUCT_SERVICE_URL + PRODUCT_SERVICE_PATH);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(ProductClient.class);
    }
}
