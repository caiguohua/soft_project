package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.ClubInfoMapper;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.service.ClubInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 11:33
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubInfoServiceImpl implements ClubInfoService {

    private final Logger logger = LoggerFactory.getLogger(ClubInfoServiceImpl.class);

    private final ClubInfoMapper clubInfoMapper;

    @Autowired
    public ClubInfoServiceImpl(ClubInfoMapper clubInfoMapper) {
        this.clubInfoMapper = clubInfoMapper;
    }

    @Override
    public void add(ClubInfoDO clubInfoDO) {
        try{
            clubInfoMapper.insertData(clubInfoDO);
        }catch (SoftException e){
            logger.error("add clubInfo is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public void update(ClubInfoDO clubInfoDO) {
        try{
            clubInfoMapper.updateData(clubInfoDO);
        }catch (SoftException e){
            logger.error("update clubInfo:",clubInfoDO.getId()+" is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public List<ClubInfoDO> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<ClubInfoDO> list = clubInfoMapper.findAll();
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public ClubInfoDO findOne(Integer id) {
        return clubInfoMapper.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        try{
            clubInfoMapper.deleteData(id);
        }catch (SoftException e){
            logger.error("delete clubInfo: ",id+" is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }
}
