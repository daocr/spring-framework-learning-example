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
