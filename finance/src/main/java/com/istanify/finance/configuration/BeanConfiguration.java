package com.istanify.finance.configuration;

import com.istanify.finance.client.AccountingClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class BeanConfiguration {

    private final DiscoveryClient discoveryClient;

    public BeanConfiguration(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    AccountingClient AccountingClient() {
        String accountingServiceUrl = discoveryClient.getInstances("accounting-service")
                .stream()
                .findFirst()
                .map(serviceInstance -> serviceInstance.getUri().toString())
                .orElseThrow(() -> new RuntimeException("Failed to find URL for accounting service"));

        RestClient client = RestClient.create(accountingServiceUrl);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(AccountingClient.class);
    }



}
