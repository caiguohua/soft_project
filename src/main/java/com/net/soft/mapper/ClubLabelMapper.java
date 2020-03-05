package com.net.soft.mapper;

import com.net.soft.model.ClubLabelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 13:36
 * @Email:cai.beyond@qq.com
 */
public interface ClubLabelMapper {
    /**
     * 新增
     * @param clubLabelDO
     */
    void insertData(@Param("record") ClubLabelDO clubLabelDO);

    /**
     * 删除
     * @param id
     */
    void deleteData(@Param("id") Integer id);

    /**
     * 更新
     * @param clubLabelDO
     */
    void updateData(@Param("record") ClubLabelDO clubLabelDO);

    /**
     * 查询
     * @return
     */
    List<ClubLabelDO> findAll();

    //ydj
}
