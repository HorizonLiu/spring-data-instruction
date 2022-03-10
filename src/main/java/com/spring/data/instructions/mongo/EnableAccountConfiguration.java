package com.spring.data.instructions.mongo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 当配置中有enable-account属性时，在beanFactory中创建这个bean
 * 下面两种关于@ConditionalOnProperty的方式作用相同
 * matchIfMissing表示，若没有enable-account属性时，是否创建该bean。该值默认为false
 *
 * @author horizonliu
 * @date 2019/3/11 8:02 PM
 */
@Configuration
@ConditionalOnProperty(prefix = "mongo",value = "enable-account", matchIfMissing = false)
//@ConditionalOnProperty(prefix = "mongo", name = "enable-account", havingValue = "true")
public class EnableAccountConfiguration {
}
