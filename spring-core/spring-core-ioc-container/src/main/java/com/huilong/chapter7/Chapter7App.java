/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter7;

import com.huilong.chapter7.service.CityService7;
import com.huilong.chapter7.service.DistrictService7;
import com.huilong.chapter7.service.impl.CityService7Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 注解形式 配置 spring
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter7App {

    public static void main(String[] args) {

//        1、基于xml 配置启用注解，创建 ApplicationContext

        // 加载配置 classPathXmlApplicationContext
//        createClassPathXmlApplicationContext();

        //2、不依赖任何xml ，完全依赖注解创建 ApplicationContext
        createAnnotationConfigApplicationContext();

    }

    private static void createClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter7/application.xml");

        test(applicationContext);

        // 关闭容器
        applicationContext.close();
    }


    private static void test(ApplicationContext applicationContext) {
        CityService7 cityService7 = applicationContext.getBean(CityService7.class);

        CityService7Impl.CityDto cityDto = cityService7.getCityName("上海");

        DistrictService7 districtService7 = applicationContext.getBean(DistrictService7.class);

        List<String> districtName = districtService7.getDistrictName(cityDto.getCityId());

        log.info("查询结果 城市信息：{} 板块信息：{}", cityDto, districtName);
    }

    /**
     * 不依赖任何xml ，完全依赖注解创建 ApplicationContext
     */
    private static void createAnnotationConfigApplicationContext() {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter7");

        annotationConfigApplicationContext.refresh();

        test(annotationConfigApplicationContext);

        // 关闭容器
        annotationConfigApplicationContext.close();
    }

}
