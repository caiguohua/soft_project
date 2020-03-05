package com.net.soft.service;

import com.net.soft.model.ClubInfoDO;
import com.net.soft.model.ClubLabelDO;
import com.net.soft.model.ClubProductDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:25
 * @Email:cai.beyond@qq.com
 */
public interface ClubProductService {

    void add(ClubProductDO clubProductDO);

    void update(ClubProductDO clubProductDO);

    List<ClubProductDO> findAll();

    ClubProductDO findOne();
}
