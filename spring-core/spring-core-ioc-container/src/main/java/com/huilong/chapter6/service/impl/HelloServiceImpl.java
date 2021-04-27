/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter6.service.impl;

import com.huilong.chapter6.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public void SayHello(String name) {

        log.info("你好：{}", name);

    }
}
