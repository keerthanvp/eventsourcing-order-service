package com.vpk.tutorial.orderservice.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig {
    @Value("${mongoDB.url}")
    private String url;

    @Value("${mongoDB.database}")
    private String database;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create(url),database);
    }
}
