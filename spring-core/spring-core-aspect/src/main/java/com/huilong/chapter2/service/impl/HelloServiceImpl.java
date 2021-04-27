/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aspect
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.service.impl;

import com.huilong.chapter2.LogAspect;
import com.huilong.chapter2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @LogAspect("来源 HelloServiceImpl")
    public void SayHello(String name) {

        log.info("你好：{}", name);

    }
}
