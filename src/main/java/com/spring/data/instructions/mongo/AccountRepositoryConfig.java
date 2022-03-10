package com.spring.data.instructions.mongo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author horizonliu
 * @date 2019/3/11 10:24 PM
 */
@EnableMongoRepositories(mongoTemplateRef = "accountMongoTemplate", basePackages = "com.spring.data.instructions.mongo")
@Configuration
@ConditionalOnBean(EnableAccountConfiguration.class)
public class AccountRepositoryConfig {
}
