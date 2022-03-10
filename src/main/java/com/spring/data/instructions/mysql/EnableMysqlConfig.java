package com.spring.data.instructions.mysql;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author horizonliu
 * @date 2019/3/12 9:43 PM
 */
@Configuration
@ConditionalOnProperty(value = "enable-mysql", matchIfMissing = false)
public class EnableMysqlConfig {
}
