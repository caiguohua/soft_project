package com.net.soft.service.impl;

import com.net.soft.exception.SoftException;
import com.net.soft.mapper.ClubLabelMapper;
import com.net.soft.model.ClubLabelDO;
import com.net.soft.service.ClubLabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:22
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubLabelServiceImpl implements ClubLabelService {
    private final Logger logger = LoggerFactory.getLogger(ClubLabelServiceImpl.class);

    @Resource
    private ClubLabelMapper clubLabelMapper;

    @Override
    public void add(ClubLabelDO clubLabelDO) {
        try{
            clubLabelMapper.insertData(clubLabelDO);
        }catch (SoftException e){
            logger.error("add this clubLabel is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public void update(ClubLabelDO clubLabelDO) {
        try{
            clubLabelMapper.updateData(clubLabelDO);
        }catch (SoftException e){
            logger.error("update this clubLabel: ",clubLabelDO.getId()+" is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public List<ClubLabelDO> findAll() {
        return clubLabelMapper.findAll();
    }

    @Override
    public ClubLabelDO findOne() {
        return null;
    }

    @Override
    public ClubLabelDO findById(Integer id) {
        return clubLabelMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {
        try{
            clubLabelMapper.deleteData(id);
        }catch (SoftException e){
            logger.error("delete this clubLabel: ",id+" is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public List<ClubLabelDO> findByCid(Integer cid) {
        return clubLabelMapper.findByCid(cid);
    }

    @Override
    public List<ClubLabelDO> findNotHasByCid(Integer cid) {
        List<ClubLabelDO> hasList = clubLabelMapper.findByCid(cid);
        List<ClubLabelDO> allList = clubLabelMapper.findAll();
        allList.removeAll(hasList);
        return allList;
    }
}
