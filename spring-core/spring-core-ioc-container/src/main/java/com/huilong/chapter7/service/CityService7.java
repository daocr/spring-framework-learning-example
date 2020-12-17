package com.huilong.chapter7.service;

import com.huilong.chapter7.service.impl.CityService7Impl;

/**
 * @author daocr
 * @date 2020/12/16
 */
public interface CityService7 {

    /**
     * 获取城市名称
     *
     * @param cityName
     * @return
     */
    CityService7Impl.CityDto getCityName(String cityName);

}
