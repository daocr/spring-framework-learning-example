/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
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
