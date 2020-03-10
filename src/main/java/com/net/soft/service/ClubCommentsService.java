package com.net.soft.service;

import com.net.soft.model.ClubCommentsDO;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 22:13
 * @Email:cai.beyond@qq.com
 */
public interface ClubCommentsService {
    List<ClubCommentsDO> findByCid(Integer cid,Integer page,Integer size);

    void delete(Integer id);

    void add(ClubCommentsDO clubCommentsDO);
}
