package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.ClubCommentsMapper;
import com.net.soft.mapper.OrderInfoMapper;
import com.net.soft.model.OrderInfoDO;
import com.net.soft.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 22:16
 * @Email:cai.beyond@qq.com
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private ClubCommentsMapper clubCommentsMapper;

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderInfoDO> findByUid(Integer uid,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<OrderInfoDO> list = orderInfoMapper.findByUid(uid);
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public void finishOrder(Integer id) {
        try {
            orderInfoMapper.finishOrder(id);
        }catch (SoftException e){

        }
    }

    @Override
    public List<OrderInfoDO> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<OrderInfoDO> list = orderInfoMapper.findAll();
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public void cancelOrder(Integer id) {
        try {
            orderInfoMapper.cancelOrder(id);
        }catch (SoftException e){
//            throw new ModelAndViewDefiningException()
        }
    }

    @Override
    public Integer findStatus(Integer id) {
        return orderInfoMapper.findById(id);
    }
}
