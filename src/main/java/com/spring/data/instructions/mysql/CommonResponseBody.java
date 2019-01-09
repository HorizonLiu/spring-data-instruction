package com.spring.data.instructions.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应基本类
 * @author horizonliu
 * @date 2019/1/9 9:59 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponseBody {
    private int code;
    private String msg;
    private Object data;
}
