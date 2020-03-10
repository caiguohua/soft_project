package com.net.soft.service;

import com.net.soft.model.OrderInfoDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 22:15
 * @Email:cai.beyond@qq.com
 */
public interface OrderInfoService {
    List<OrderInfoDO> findByUid(Integer uid,Integer page,Integer size);
    void finishOrder(Integer id);
    List<OrderInfoDO> findAll(Integer page,Integer size);
    void cancelOrder(Integer id);
    Integer findStatus(Integer id);
}
