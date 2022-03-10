package com.spring.data.instructions.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author horizonliu
 * @date 2019/5/9 9:06 PM
 */

@Service
public class MysqlOperationService {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
