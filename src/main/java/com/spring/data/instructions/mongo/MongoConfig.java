package com.spring.data.instructions.mongo;

import com.mongodb.MongoClient;
import com.spring.data.instructions.generalconfig.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * 创建针对各个collection分别进行读写的mongoTemplate
 * 这里只先对user的读写创建了accountMongoTemplate
 *
 * @author horizonliu
 * @date 2019/3/11 7:46 PM
 */
@Configuration
public class MongoConfig {
    @Autowired
    private Config config;

    @Bean(value = "accountMongoTemplate")
    @ConditionalOnBean(EnableAccountConfiguration.class)
    public MongoTemplate accountMongoTemplate() {
        final MongoProperties mongoProperties = config.getAccountMongo();
        return new MongoTemplate(new MongoClient(), mongoProperties.getMongoClientDatabase());
    }
}
