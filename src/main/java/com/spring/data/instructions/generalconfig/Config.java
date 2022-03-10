package com.spring.data.instructions.generalconfig;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author horizonliu
 * @date 2019/3/11 8:16 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mongo")
public class Config {
    private MongoProperties accountMongo = new MongoProperties();
    private String enableAccount;
}
