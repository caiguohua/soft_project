package com.net.soft.exception;

import lombok.Data;

/**
 * @author caiguohua
 * @date 2020/2/27 15:12
 * @Email:cai.beyond@qq.com
 */
@Data
public class SoftException extends RuntimeException {
    private Integer code;

    public SoftException(Integer code ,String message) {
        super(message);
        this.code = code;
    }

}
