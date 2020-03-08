package com.net.soft.service.impl;

import com.net.soft.mapper.ClubInfoMapper;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.service.ClubInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 11:33
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubInfoServiceImpl implements ClubInfoService {

    @Resource
    private ClubInfoMapper clubInfoMapper;

    @Override
    public void add(ClubInfoDO clubInfoDO) {

    }

    @Override
    public void update(ClubInfoDO clubInfoDO) {

    }

    @Override
    public List<ClubInfoDO> findAll() {
        return clubInfoMapper.findAll();
    }

//    @Override
//    public ClubInfoDO findOne() {
//        return clubInfoMapper.getCludInfoById();
//    }

    @Override
    public ClubInfoDO findClubInfoById(int id) {

        return clubInfoMapper.getCludInfoById(id);

    }

    @Override
    public List<ClubInfoDO> getClubInfoByLabel(int labelId) {
        return clubInfoMapper.getClubInfoByLabel(labelId);
    }

}
