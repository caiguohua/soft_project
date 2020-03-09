package com.net.soft.utils;

import com.net.soft.enums.CodeEnum;

/**
 * 枚举工具类
 * @author caiguohua
 * @date 2020/3/9 13:00
 * @Email:cai.beyond@qq.com
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
