package com.spring.data.instructions.mongo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.PartialIndexFilter;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.annotation.PostConstruct;

/**
 * 为user collection创建索引
 *
 * @author horizonliu
 * @date 2019/3/11 8:37 PM
 */
@Data
@Configuration
@DependsOn("accountMongoTemplate")
@ConditionalOnBean(EnableAccountConfiguration.class)
public class UserMongoConfig {
    @Autowired
    @Qualifier("accountMongoTemplate")
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initIndexs() {
        // 当nation和phone存在且不为空字符串时创建唯一索引
        mongoTemplate.indexOps(User.class)
                .ensureIndex(new Index().on("phone", Sort.Direction.ASC)
                        .background()
                        .unique()
                        .partial(PartialIndexFilter.of(
                                Criteria.where("phone").exists(true)
                                        .and("nation").exists(true)
                        )));

        // 当email存在且不为空时创建email的唯一索引
        mongoTemplate.indexOps(User.class)
                .ensureIndex(new Index().on("email", Sort.Direction.ASC)
                .background()
                .unique()
                .partial(PartialIndexFilter.of((
                        Criteria.where("email").exists(true)
                ))));
    }
}
