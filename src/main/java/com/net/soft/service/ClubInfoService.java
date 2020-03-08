package com.net.soft.service;

import com.net.soft.model.ClubInfoDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 11:31
 * @Email:cai.beyond@qq.com
 */
public interface ClubInfoService {

    void add(ClubInfoDO clubInfoDO);

    void update(ClubInfoDO clubInfoDO);

    List<ClubInfoDO> findAll();

    ClubInfoDO findOne();

    ClubInfoDO findClubInfoById(int id);
}
