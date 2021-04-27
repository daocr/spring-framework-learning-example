/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter7.scan;

import com.huilong.chapter7.service.CityService7;
import com.huilong.chapter7.service.DistrictService7;
import com.huilong.chapter7.service.impl.CityService7Impl;
import com.huilong.chapter7.service.impl.DistrictService7Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author daocr
 * @date 2020/12/18
 */
@Configuration
public class BeanConfig {


    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Primary
    public CityService7 cityService7() {
        return new CityService7Impl();
    }


    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Primary
    public DistrictService7 districtService7() {
        return new DistrictService7Impl();
    }


}
