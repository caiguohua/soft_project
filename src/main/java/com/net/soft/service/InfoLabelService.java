package com.net.soft.service;

import com.net.soft.model.InfoLabelDO;

/**
 * @author caiguohua
 * @date 2020/3/7 16:52
 * @Email:cai.beyond@qq.com
 */
public interface InfoLabelService {
    void insert(InfoLabelDO infoLabelDO);

    void delete(Integer cid, Integer lid);
}
