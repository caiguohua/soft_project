package com.net.soft.enums;

import lombok.Getter;

/**
 * @author caiguohua
 * @date 2020/3/9 16:37
 * @Email:cai.beyond@qq.com
 */
@Getter
public enum UserTypeEnum implements CodeEnum {
    COMMON(0, "普通用户"),
    VIP(1, "VIP"),
    ADMIN(2, "管理员"),
    ;

    private Integer code;

    private String message;

    UserTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
