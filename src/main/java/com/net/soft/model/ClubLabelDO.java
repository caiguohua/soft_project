package com.net.soft.model;

import lombok.Data;

import java.util.Date;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        ClubLabelDO that = (ClubLabelDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(labelName, that.labelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, labelName);
    }
}
