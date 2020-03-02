package com.net.soft.model;

import lombok.Data;

/**
 * @author caiguohua
 * @date 2020/3/2 12:34
 * @Email:cai.beyond@qq.com
 */
@Data
public class UserInfoDO {
    private Integer id;
    private String name;
    private String password;
    private Integer type;
    private Boolean isvalid;
}
