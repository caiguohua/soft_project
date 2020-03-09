package com.net.soft.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.net.soft.enums.ProductPriceDateUnitEnum;
import com.net.soft.enums.UserTypeEnum;
import com.net.soft.utils.EnumUtil;
import lombok.Data;

import java.util.Date;

/**
 * @author caiguohua
 * @date 2020/3/9 16:39
 * @Email:cai.beyond@qq.com
 */
@Data
public class UserDTO {
    private Integer id;
    private String phone;
    private String name;
    private Integer type;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public UserTypeEnum getTypeEnum() {
        return EnumUtil.getByCode(type, UserTypeEnum.class);
    }
}
