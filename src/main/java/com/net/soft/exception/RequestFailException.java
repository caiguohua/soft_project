package com.net.soft.exception;

/**
 * @author caiguohua
 * @date 2020/2/27 15:08
 * @Email:cai.beyond@qq.com
 */

public class RequestFailException extends RuntimeException {
    public RequestFailException(String message) {
        super(message);
    }
}
