package com.istanify.finance.configuration;

import com.istanify.finance.client.AccountingClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class BeanConfiguration {
    public static final String ACCOUNTING_SERVICE_URL = "http://localhost:9696";


    @Bean
    AccountingClient AccountingClient() {
        RestClient client = RestClient.create(ACCOUNTING_SERVICE_URL);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(AccountingClient.class);
    }

}
