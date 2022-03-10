package com.spring.data.instructions.controller;

import com.spring.data.instructions.mongo.User;
import com.spring.data.instructions.mongo.UserRepository;
import com.spring.data.instructions.mysql.CommonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author horizonliu
 * @date 2019/3/11 9:14 PM
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    @Qualifier("accountMongoTemplate")
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/write_user")
    public CommonResponseBody writeUser(@RequestBody User user) {
        if (user.getEmail() == null && user.getPhone() == null) {
            return new CommonResponseBody("invalid input");
        }

        mongoTemplate.save(user);

        return new CommonResponseBody(0, "SUCCESS", "OH YEAH!!");
    }


    @PostMapping(value = "/read_user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResponseBody readUser(@RequestBody User user) {
        if (user.getPhone() == null && user.getEmail() == null) {
            return new CommonResponseBody("invalid input");
        }

        return new CommonResponseBody(userRepository.findByRequest(user));
    }
}
