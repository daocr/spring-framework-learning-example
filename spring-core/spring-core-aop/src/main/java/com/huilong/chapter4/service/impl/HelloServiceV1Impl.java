/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aop
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter4.service.impl;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Service("helloServiceV1")
public class HelloServiceV1Impl implements HelloService {

    @Override
    public void SayHello(String name) {
        log.info("你好：{} 实现类：{}", name,this.getClass().getName());


        if ("赵六".equals(name)) {
            throw new RuntimeException();
        }

    }
}
