package com.net.soft.service;

import com.net.soft.model.UserInfoDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:28
 * @Email:cai.beyond@qq.com
 */
public interface UserInfoService {

    void add(UserInfoDO userInfoDO);

    void update(UserInfoDO userInfoDO);

    List<UserInfoDO> findAll();

    UserInfoDO findOne();
}
