package com.net.soft.mapper;

import com.net.soft.model.ClubCommentsDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/8 23:32
 * @Email:cai.beyond@qq.com
 */
public interface ClubCommentsMapper {
    List<ClubCommentsDO> findByCid(@Param("cid") Integer cid);
    void deleteData(@Param("id") Integer id);
    void insert(@Param("record") ClubCommentsDO clubCommentsDO);
}
