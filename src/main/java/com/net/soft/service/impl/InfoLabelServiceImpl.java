package com.net.soft.service.impl;

import com.net.soft.mapper.InfoLabelMapper;
import com.net.soft.model.InfoLabelDO;
import com.net.soft.service.InfoLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author caiguohua
 * @date 2020/3/7 16:53
 * @Email:cai.beyond@qq.com
 */
@Service
public class InfoLabelServiceImpl implements InfoLabelService {

    @Resource
    private InfoLabelMapper infoLabelMapper;

    @Override
    public void insert(InfoLabelDO infoLabelDO) {
        infoLabelMapper.insertData(infoLabelDO);
    }

    @Override
    public void delete(Integer cid, Integer lid) {
        infoLabelMapper.deleteData(cid,lid);
    }
}
