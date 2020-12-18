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
