package com.net.soft.common;

import lombok.Data;

/**
 * 结果集
 * @author caiguohua
 * @date 2020/2/27 11:56
 * @Email:cai.beyond@qq.com
 */
@Data
public class ResultVO {

    private Integer code;

    private String message;

    private Object data;

    public ResultVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
