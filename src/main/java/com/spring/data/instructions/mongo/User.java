package com.spring.data.instructions.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 存储在mongodb中的数据
 * 表名：user
 * 包含用户Id、手机号和邮箱等字段
 * @author horizonliu
 * @date 2019/3/11 7:41 PM
 */
@Data
@Document(collection = "user")
public class User {
    @Id
    @Field("id")
    private Integer id;

    @Field("nation")
    private String nation = "86";

    @Field("phone")
    private String phone;

    @Field("email")
    private String email;

}
