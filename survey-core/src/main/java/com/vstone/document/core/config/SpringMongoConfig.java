package com.vstone.document.core.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Configuration
//@EnableMongoRepositories(basePackages = "com.vstone.document.core.repository")
public class SpringMongoConfig {

    /*@Value(value = "${mongoHost}")
    private String mongoHost;
    @Value(value = "${mongoPort}")
    private int mongoPort;
    @Value(value = "${mongoDatabase}")
    private String mongoDatabase;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(mongoHost, mongoPort), mongoDatabase);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }*/
}
