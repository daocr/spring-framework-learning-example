package com.huilong.chapter3.service.impl;

import com.huilong.chapter3.service.DependencyInjectionHelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class DependencyInjectionServiceImpl implements DependencyInjectionHelloService {

    public String desc;

    public DependencyInjectionServiceImpl() {
    }

    // 构造方法 注入
    public DependencyInjectionServiceImpl(String desc) {
        this.desc = desc;
    }

    // set 方法注入
    public DependencyInjectionServiceImpl setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    @Override
    public void SayHello(String name) {

        log.info("desc 注入来源 ：{}  |   你好：{}", desc, name);

    }


}
