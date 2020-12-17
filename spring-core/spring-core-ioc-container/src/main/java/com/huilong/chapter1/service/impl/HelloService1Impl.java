package com.huilong.chapter1.service.impl;

import com.huilong.chapter1.service.HelloService1;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloService1Impl implements HelloService1 {

    @Override
    public void SayHello(String name) {

        log.info("你好：{}", name);

    }
}
