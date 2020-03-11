package com.net.soft.mapper;

import com.net.soft.model.ClubInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 12:46
 * @Email:cai.beyond@qq.com
 */
@Repository
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

    /**
     * 通过id查询
     * @param id
     * @return
     */
    ClubInfoDO findOne(@Param("id") Integer id);

    //ydj

    /**
     * 根据id查询
     * @return
     */
    ClubInfoDO getCludInfoById(int id);

    /**
     * 根据标签id查询
     * @param labelId
     * @return
     */
    List<ClubInfoDO> getClubInfoByLabel(@Param("labelId") int labelId);



}


