package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.UserInfoMapper;
import com.net.soft.model.UserInfoDO;
import com.net.soft.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:29
 * @Email:cai.beyond@qq.com
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfoDO userInfoDO) {
        userInfoMapper.insertData(userInfoDO);
    }

    @Override
    public void update(UserInfoDO userInfoDO) {
        userInfoMapper.updateData(userInfoDO);
    }

    @Override
    public List<UserInfoDO> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<UserInfoDO> list = userInfoMapper.findAll();
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public UserInfoDO findOne(Integer id) {
        return userInfoMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {
        try{
            userInfoMapper.deleteData(id);
        }catch (SoftException e){
            logger.error("封号："+id+"失败，errorMessage:[{}]，errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }

    }
}
