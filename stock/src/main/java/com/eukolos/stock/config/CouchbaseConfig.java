package com.eukolos.stock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {


    @Value("${couchbase.stock-service.config.bootstrapHosts}")
    private String connectionString;

    @Value("${couchbase.stock-service.config.stockBucketUsername}")
    private String username;

    @Value("${couchbase.stock-service.config.stockBucketPassword}")
    private String password;

    @Value("${couchbase.stock-service.config.stockBucket}")
    private String bucketName;

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }
}