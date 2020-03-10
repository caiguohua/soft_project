package com.net.soft.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.net.soft.enums.OrderStatusEnum;
import com.net.soft.enums.ProductPriceDateUnitEnum;
import com.net.soft.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author caiguohua
 * @date 2020/3/9 15:39
 * @Email:cai.beyond@qq.com
 */
@Data
public class OrderDTO {
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

    @JsonIgnore
    public ProductPriceDateUnitEnum getDateUnitEnum() {
        return EnumUtil.getByCode(dateUnit, ProductPriceDateUnitEnum.class);
    }

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(status, OrderStatusEnum.class);
    }

}
