package com.spring.data.instructions.mongo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @author horizonliu
 * @date 2019/3/11 9:25 PM
 */
@Component
@ConditionalOnBean(EnableAccountConfiguration.class)
public interface UserRepository extends MongoRepository<User, Integer> {

    User findById(int id);

    User findByNationAndPhone(String nation, String phone);

    User findByEmail(String email);

    default User findByRequest(User user) {
        if (user.getEmail() != null) {
            return findByEmail(user.getEmail());
        } else if (user.getPhone() != null && user.getNation() != null) {
            return findByNationAndPhone(user.getNation(), user.getPhone());
        } else {
            return null;
        }
    }

}
