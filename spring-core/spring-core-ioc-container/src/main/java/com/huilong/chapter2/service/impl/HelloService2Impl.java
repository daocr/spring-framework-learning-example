package com.huilong.chapter2.service.impl;

import com.huilong.chapter2.service.HelloService2;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloService2Impl implements HelloService2 {



    @Override
    public void SayHello(String name) {

        log.info(" 你好：{}",  name);

    }



}
