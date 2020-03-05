package com.net.soft.model;

import lombok.Data;

import java.sql.Date;

/**
 * @author caiguohua
 * @date 2020/3/2 12:33
 * @Email:cai.beyond@qq.com
 */
@Data
public class InfoLabelDO {
    private Integer id;
    private Integer cid;
    private Integer lid;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
