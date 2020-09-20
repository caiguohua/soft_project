package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.OrderInfoMapper;
import com.net.soft.model.ClubProductDO;
import com.net.soft.model.OrderInfoDO;
import com.net.soft.model.UserInfoDO;
import com.net.soft.service.ClubProductService;
import com.net.soft.service.OrderInfoService;
import com.net.soft.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

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
            logger.error("完结订单失败！订单id:"+id);
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
            Integer pid = orderInfoMapper.findPidById(id);
            clubProductService.addSum(pid);
        }catch (SoftException e){
        }
    }

    @Override
    public Integer findStatus(Integer id) {
        return orderInfoMapper.findStatusById(id);
    }

    /**
     * 预约下单
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public Boolean createOrder(Integer uid, Integer pid) {
        Integer type = userInfoService.findOne(uid).getType();
        if(type == 0){
            Integer num = orderInfoMapper.findNumByUid(uid);
            if(num > 3){
                return false;
            }
        }
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
            return true;
        }
        return false;
    }
}
