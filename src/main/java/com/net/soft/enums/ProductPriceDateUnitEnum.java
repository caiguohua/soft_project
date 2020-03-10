package com.net.soft.enums;

import lombok.Getter;

/**
 * 商品价格时间单位枚举类
 * @author caiguohua
 * @date 2020/3/9 13:06
 * @Email:cai.beyond@qq.com
 */
@Getter
public enum ProductPriceDateUnitEnum implements CodeEnum{
    DAY(0, "一天"),
    WEEK(1, "一周"),
    MONTH(2, "一月"),
    QUARTER(3, "一季"),
    YEAR(4,"一年")
    ;

    private Integer code;

    private String message;

    ProductPriceDateUnitEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
