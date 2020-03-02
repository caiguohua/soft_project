package com.net.soft.model;

import lombok.Data;

/**
 * club_info 实体类
 *
 * @author caiguohua
 * @date 2020/3/2 12:03
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubInfoDO {
    private Integer id;
    private String name;
    private String description;
    private String phone;
    private String address;
    private String cover_image;
    private String comments;
    private Integer sequence;
    private Boolean isvalid;
}
