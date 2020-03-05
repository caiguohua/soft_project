package com.net.soft.service;

import com.net.soft.model.ClubInfoDO;
import com.net.soft.model.ClubLabelDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 11:33
 * @Email:cai.beyond@qq.com
 */
public interface ClubLabelService {

    void add(ClubLabelDO clubLabelDO);

    void update(ClubLabelDO clubLabelDO);

    List<ClubLabelDO> findAll();

    ClubLabelDO findOne();
}
