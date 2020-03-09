package com.net.soft.mapper;

import com.net.soft.model.InfoLabelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caiguohua
 * @date 2020/3/3 13:38
 * @Email:cai.beyond@qq.com
 */
public interface InfoLabelMapper {
    /**
     * 新增
     * @param infoLabelDO
     */
    void insertData(@Param("record") InfoLabelDO infoLabelDO);

    /**
     * 删除
     * @param cid
     * @param lid
     */
    void deleteData(@Param("cid") Integer cid,@Param("lid") Integer lid);

    /**
     * 更新
     * @param infoLabelDO
     */
    void updateData(@Param("record") InfoLabelDO infoLabelDO);

    /**
     * 查询
     * @return
     */
    List<InfoLabelDO> findAll();

    //ydj

}
