package com.net.soft.from;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author caiguohua
 * @date 2020/3/6 21:29
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubProductForm {
    private Integer id;
    private Integer cid;
    private String name;
    private String desc;
    private BigDecimal price;
    private Integer dateUnit;
    private Integer sum;
}
