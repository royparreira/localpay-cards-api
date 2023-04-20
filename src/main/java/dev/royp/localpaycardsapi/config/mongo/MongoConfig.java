package dev.royp.localpaycardsapi.config.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = "dev.royp.localpaycardsapi.gateway.mongodb.repository")
public class MongoConfig {}
