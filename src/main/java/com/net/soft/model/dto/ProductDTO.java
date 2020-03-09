package com.net.soft.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.net.soft.enums.ProductPriceDateUnitEnum;
import com.net.soft.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author caiguohua
 * @date 2020/3/9 14:36
 * @Email:cai.beyond@qq.com
 */
@Data
public class ProductDTO {
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

    @JsonIgnore
    public ProductPriceDateUnitEnum getDateUnitEnum() {
        return EnumUtil.getByCode(dateUnit, ProductPriceDateUnitEnum.class);
    }
}
