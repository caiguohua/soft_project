package com.net.soft.model;

import lombok.Data;

import java.util.Date;

/**
 * @author caiguohua
 * @date 2020/3/8 18:56
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubCommentsDO {
    private Integer id;
    private Integer cid;
    private Integer uid;
    private String comment;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
