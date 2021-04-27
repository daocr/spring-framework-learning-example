/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter8.service.impl;

import com.huilong.chapter8.service.HelloService8;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloService8Impl implements HelloService8 {

    @Override
    public void SayHello(String name) {

        log.info("你好：{} ", name);

    }
}
