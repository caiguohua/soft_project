package com.net.soft.mapper;

import com.net.soft.model.ClubProductDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 13:36
 * @Email:cai.beyond@qq.com
 */
public interface ClubProductMapper {
    /**
     * 新增
     * @param clubProductDO
     */
    void insertData(@Param("record") ClubProductDO clubProductDO);

    /**
     * 删除
     * @param id
     */
    void deleteData(@Param("id") Integer id);

    /**
     * 更新
     * @param clubProductDO
     */
    void updateData(@Param("record") ClubProductDO clubProductDO);

    /**
     * 查询
     * @return
     */
    List<ClubProductDO> findAll();

    //ydj

}
