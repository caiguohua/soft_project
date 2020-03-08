package com.net.soft.service.impl;

import com.net.soft.mapper.ClubLabelMapper;
import com.net.soft.model.ClubLabelDO;
import com.net.soft.service.ClubLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:22
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubLabelServiceImpl implements ClubLabelService {

    @Autowired
    ClubLabelMapper clubLabelMapper;

    @Override
    public void add(ClubLabelDO clubLabelDO) {

    }

    @Override
    public void update(ClubLabelDO clubLabelDO) {

    }

    @Override
    public List<ClubLabelDO> findAll() {
        return clubLabelMapper.findAll();
    }

//    @Override
//    public ClubLabelDO findOne() {
//        return null;
//    }
}
