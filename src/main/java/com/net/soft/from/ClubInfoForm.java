package com.net.soft.from;

import lombok.Data;

/**
 * @author caiguohua
 * @date 2020/3/5 13:27
 * @Email:cai.beyond@qq.com
 */
@Data
public class ClubInfoForm {
    private Integer id;
    private String name;
    private String description;
    private String phone;
    private String address;
    private String coverImage;
    private Integer sequence;
}
