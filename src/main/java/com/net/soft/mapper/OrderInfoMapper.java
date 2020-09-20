package com.net.soft.mapper;

import com.net.soft.model.OrderInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 23:34
 * @Email:cai.beyond@qq.com
 */
public interface OrderInfoMapper {
    /**
     * 通过用户id查询
     * @param uid
     * @return
     */
    List<OrderInfoDO> findByUid(@Param("uid") Integer uid);

    /**
     * 查询所有订单
     *
     * @return
     */
    List<OrderInfoDO> findAll();

    /**
     * 完结订单
     *
     * @param id
     */
    void finishOrder(@Param("id") Integer id);

    /**
     * 取消订单
     *
     * @param id
     */
    void cancelOrder(@Param("id")Integer id);

    /**
     * 通过id查询订单状态
     * @param id
     * @return
     */
    Integer findStatusById(@Param("id")Integer id);

    /**
     * 创建订单
     * @param orderInfoDO
     */
    void insert(@Param("record") OrderInfoDO orderInfoDO);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Integer findPidById(@Param("id") Integer id);

    /**
     * 查询用户订单数量
     * @param uid
     * @return
     */
    Integer findNumByUid(Integer uid);
}
