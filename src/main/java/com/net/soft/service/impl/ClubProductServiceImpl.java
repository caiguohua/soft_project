package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.exception.SoftException;
import com.net.soft.mapper.ClubProductMapper;
import com.net.soft.model.ClubProductDO;
import com.net.soft.service.ClubProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/5 12:27
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubProductServiceImpl implements ClubProductService {
    private final Logger logger = LoggerFactory.getLogger(ClubProductServiceImpl.class);

    @Resource
    private ClubProductMapper clubProductMapper;

    @Override
    public void add(ClubProductDO clubProductDO) {
        try{
            clubProductMapper.insertData(clubProductDO);
        }catch (SoftException e){
            logger.error("add this clubProduct is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public void update(ClubProductDO clubProductDO) {
        try{
            clubProductMapper.updateData(clubProductDO);
        }catch (SoftException e){
            logger.error("update this clubProduct: ",clubProductDO.getId() +"  is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public List<ClubProductDO> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<ClubProductDO> list = clubProductMapper.findAll();
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public List<ClubProductDO> findByCid(Integer cid,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<ClubProductDO> list = clubProductMapper.findByCid(cid);
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
        try{
            clubProductMapper.deleteData(id);
        }catch (SoftException e){
            logger.error("delete this clubProduct:",id +" is error,errorMessage:[{}],errorStackTrace:[{}]",e.getMessage(),e.getStackTrace());
        }
    }

    @Override
    public ClubProductDO findById(Integer id) {
        return clubProductMapper.findById(id);
    }

    @Override
    public void addSum(Integer pid) {
        Integer sum = clubProductMapper.findById(pid).getSum() + 1;
        clubProductMapper.addSum(pid,sum);
    }
}
