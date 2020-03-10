package com.net.soft.service.impl;

import com.github.pagehelper.PageHelper;
import com.net.soft.mapper.ClubCommentsMapper;
import com.net.soft.model.ClubCommentsDO;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.service.ClubCommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 22:14
 * @Email:cai.beyond@qq.com
 */
@Service
public class ClubCommentsServiceImpl implements ClubCommentsService {

    @Resource
    private ClubCommentsMapper clubCommentsMapper;

    @Override
    public List<ClubCommentsDO> findByCid(Integer cid,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<ClubCommentsDO> list = clubCommentsMapper.findByCid(cid);
        if(list == null || list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void add(ClubCommentsDO clubCommentsDO) {
        clubCommentsMapper.insert(clubCommentsDO);
    }
}
