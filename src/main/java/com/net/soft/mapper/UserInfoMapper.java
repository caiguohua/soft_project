package com.net.soft.mapper;

import com.net.soft.model.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 13:37
 * @Email:cai.beyond@qq.com
 */
public interface UserInfoMapper {
    /**
     * 新增
     * @param userInfoDO
     */
    void insertData(@Param("record") UserInfoDO userInfoDO);

    /**
     * 删除
     * @param id
     */
    void deleteData(@Param("id") Integer id);

    /**
     * 更新
     * @param userInfoDO
     */
    void updateData(@Param("record") UserInfoDO userInfoDO);

    /**
     * 查询
     * @return
     */
    List<UserInfoDO> findAll();

    /**
     * 通过id查询
     * @param id
     * @return
     */
    UserInfoDO findById(@Param("id") Integer id);

    //ydj
}
