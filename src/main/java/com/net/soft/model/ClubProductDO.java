package com.net.soft.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author caiguohua
 * @date 2020/3/2 12:30
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubProductDO {
    private Integer id;
    private Integer cid;
    private String name;
    private String desc;
    private BigDecimal price;
    private Integer dateUnit;
    private Integer sum;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
