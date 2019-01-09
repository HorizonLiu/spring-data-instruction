package com.spring.data.instructions.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * mysql增删改查等 rest api接口定义
 *
 * @author horizonliu
 * @date 2019/1/9 9:38 PM
 */

@RestController
@RequestMapping(value = "/{version}/mysql")
public class MysqlController {

    @Autowired
    private RecordsRepository recordsRepository;

    @PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResponseBody findByName(@PathVariable("version") String version,
                                         @RequestBody CommonRequest request) {

        Object resData = null;
        switch (request.getQueryOp()) {
            case "all":
                resData = recordsRepository.findAll();
                break;
            case "byId":
                resData = recordsRepository.findById(request.getId()).orElse(null);
                break;
            default:
                break;
        }


        return CommonResponseBody
                .builder()
                .code(0)
                .msg("success")
                .data(resData)
                .build();
    }

}
