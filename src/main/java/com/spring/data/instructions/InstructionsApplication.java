package com.spring.data.instructions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author horizonliu
 * @date 2019/1/9 9:38 PM
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class InstructionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructionsApplication.class, args);
    }

}

