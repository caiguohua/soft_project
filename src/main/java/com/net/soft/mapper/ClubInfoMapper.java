package com.net.soft.mapper;

import com.net.soft.model.ClubInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 12:46
 * @Email:cai.beyond@qq.com
 */
public interface ClubInfoMapper {
    /**
     * 新增
     * @param clubInfoDO
     */
    void insertData(@Param("record") ClubInfoDO clubInfoDO);

    /**
     * 删除
     * @param id
     */
    void deleteData(@Param("id") Integer id);

    /**
     * 更新
     * @param clubInfoDO
     */
    void updateData(@Param("record") ClubInfoDO clubInfoDO);

    /**
     * 查询
     * @return
     */
    List<ClubInfoDO> findAll();

    //ydj

    /**
     * 根据id查询
     * @return
     */
    ClubInfoDO getCludInfoById(int id);



}


