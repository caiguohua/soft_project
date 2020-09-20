package com.net.soft.service;

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

    List<ClubProductDO> findAll(Integer page,Integer size);

    List<ClubProductDO> findByCid(Integer cid,Integer page,Integer size);

    void delete(Integer id);

    ClubProductDO findById(Integer id);

    void addSum(Integer pid);
}
