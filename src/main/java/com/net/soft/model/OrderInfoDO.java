package com.net.soft.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author caiguohua
 * @date 2020/3/8 18:57
 * @Email:cai.beyond@qq.com
 */
@Data
public class OrderInfoDO {
    private Integer id;
    private Integer uid;
    private String userName;
    private String userPhone;
    private Integer pid;
    private String productName;
    private BigDecimal productPrice;
    private Integer dateUnit;
    private Integer status;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
