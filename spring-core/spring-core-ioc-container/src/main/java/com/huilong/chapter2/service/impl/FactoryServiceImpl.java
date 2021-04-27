/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.service.impl;

import com.huilong.chapter2.service.FactoryService;
import com.huilong.chapter2.service.HelloService2;

public class FactoryServiceImpl implements FactoryService {

    private static HelloService2 helloService = new HelloService2Impl();

    // 静态方法
    public static HelloService2 createInstance() {
        return helloService;
    }

    // 普通方法
    public HelloService2 createInstance2() {
        return new HelloService2Impl();
    }


    public FactoryServiceImpl() {
    }

}