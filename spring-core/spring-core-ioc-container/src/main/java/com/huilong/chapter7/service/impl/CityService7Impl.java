/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter7.service.impl;

import com.huilong.chapter7.service.CityService7;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author daocr
 * @date 2020/12/16
 */
@Service
@Slf4j
public class CityService7Impl implements CityService7 {

    private List<CityDto> cache;

    /**
     * 初始化 模拟从外部加载数据
     */
    @PostConstruct
    public void init() {


        cache = new ArrayList<>();

        cache.add(new CityDto(1, "上海"));

        log.info("初始化城市数据完成 {}", cache);
    }


    /**
     * 模拟释放一些资源
     */
    @PreDestroy
    public void destroy() {
        cache = null;

        log.info("销毁城市数据完成 ！");
    }


    @Override
    public CityDto getCityName(String cityName) {

        // 模拟从数据库查询数据
        Optional<CityDto> first = cache.stream().filter(cityDto -> cityDto.getCityName().equals(cityName)).findFirst();

        return first.orElse(null);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CityDto {
        private Integer cityId;
        private String cityName;
    }
}
