package com.net.soft.service;

import com.net.soft.model.ClubInfoDO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 11:31
 * @Email:cai.beyond@qq.com
 */
public interface ClubInfoService {

    void add(ClubInfoDO clubInfoDO);

    void update(ClubInfoDO clubInfoDO);

    List<ClubInfoDO> findAll(Integer page,Integer size);

    ClubInfoDO findOne(Integer id);

    void delete(Integer id);
}
