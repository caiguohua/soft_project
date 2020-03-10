package com.net.soft.model;

import lombok.Data;
import java.util.Date;

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
    private String coverImage;
    private Integer sequence;
    private Boolean isvalid;
    private Date createTime;
    private Date updateTime;
}
