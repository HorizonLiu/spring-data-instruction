package com.spring.data.instructions.mysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author horizonliu
 * @date 2019/1/9 10:01 PM
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommonRequest {
    private long id;
    private String name;
    private int age;

    /**
     * 查询操作findAll, findById等等
     */
    private String queryOp;
}
