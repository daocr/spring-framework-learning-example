package com.huilong.chapter2.service.impl;

import com.huilong.chapter2.service.FactoryService;
import com.huilong.chapter2.service.HelloService;

public class FactoryServiceImpl implements FactoryService {

    private static HelloService helloService = new HelloServiceImpl();

    // 静态方法
    public static HelloService createInstance() {
        return helloService;
    }

    // 普通方法
    public HelloService createInstance2() {
        return new HelloServiceImpl();
    }


    private String chapterName;

    public String desc;

    public FactoryServiceImpl() {
    }

    public FactoryServiceImpl(String chapterName) {
        this.chapterName = chapterName;
    }
}