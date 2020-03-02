package com.net.soft.model;

import lombok.Data;

import java.sql.Date;

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
    private String price;
    private String dateUnit;
    private Date starTime;
    private Date endTime;
    private Boolean isvalid;
}
