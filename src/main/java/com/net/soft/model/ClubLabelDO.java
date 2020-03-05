package com.net.soft.model;

import lombok.Data;

import java.sql.Date;

/**
 * @author caiguohua
 * @date 2020/3/2 12:29
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubLabelDO {
    private Integer id;
    private String labelName;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
