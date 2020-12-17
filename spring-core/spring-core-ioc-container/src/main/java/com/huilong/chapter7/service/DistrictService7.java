package com.huilong.chapter7.service;

import lombok.Data;

import java.util.List;

/**
 * 区域 服务
 *
 * @author daocr
 * @date 2020/12/16
 */
public interface DistrictService7 {



    /**
     * 获取城市下面的板块
     *
     * @param cityId
     * @return
     */
    List<String> getDistrictName(Integer cityId);




}
