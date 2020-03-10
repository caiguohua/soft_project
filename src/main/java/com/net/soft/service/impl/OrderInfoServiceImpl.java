package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.ClubCommentsMapper;
import com.net.soft.mapper.OrderInfoMapper;
import com.net.soft.model.ClubProductDO;
import com.net.soft.model.OrderInfoDO;
import com.net.soft.model.UserInfoDO;
import com.net.soft.service.ClubProductService;
import com.net.soft.service.OrderInfoService;
import com.net.soft.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final UserInfoService userInfoService;
    private final ClubProductService clubProductService;

    @Autowired
    public OrderInfoServiceImpl(UserInfoService userInfoService, ClubProductService clubProductService) {
        this.userInfoService = userInfoService;
        this.clubProductService = clubProductService;
    }


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

    /**
     * 预约下单
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public Integer createOrder(Integer uid, Integer pid) {
        ClubProductDO clubProductDO = clubProductService.findById(pid);
        if (clubProductDO.getSum() > 0) {
            //库存-1
            Integer newSum = clubProductDO.getSum() - 1;
            ClubProductDO newClubProductDO = new ClubProductDO();
            newClubProductDO.setId(pid);
            newClubProductDO.setSum(newSum);
            clubProductService.update(newClubProductDO);
            //订单入库
            UserInfoDO userInfoDO = userInfoService.findOne(uid);
            OrderInfoDO orderInfoDO = new OrderInfoDO();
            orderInfoDO.setUid(userInfoDO.getId());
            orderInfoDO.setUserPhone(userInfoDO.getPhone());
            orderInfoDO.setUserName(userInfoDO.getName());
            orderInfoDO.setPid(clubProductDO.getId());
            orderInfoDO.setProductName(clubProductDO.getName());
            orderInfoDO.setProductPrice(clubProductDO.getPrice());
            orderInfoDO.setDateUnit(clubProductDO.getDateUnit());
            orderInfoMapper.insert(orderInfoDO);
            return 1;
        }
        return 0;
    }
}
