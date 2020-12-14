package com.huilong.chapter3.service.impl;

import com.huilong.chapter3.service.DependencyInjectionHelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class DependencyInjectionServiceImpl implements DependencyInjectionHelloService {


    @Override
    public void SayHello(String name) {

        log.info(" 你好：{}",  name);

    }



}
