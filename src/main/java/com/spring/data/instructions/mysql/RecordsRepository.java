package com.spring.data.instructions.mysql;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author horizonliu
 * @date 2019/1/9 9:48 PM
 */
@Component
@ConditionalOnBean(EnableMysqlConfig.class)
public interface RecordsRepository extends JpaRepository<Records, Long> {
}
