/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter3.service.impl;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author daocr
 * @date 2020/12/14
 */

@ToString
@Slf4j
public class ComplexObject {

    private Properties adminEmails;
    private List<String> someList;
    private Map<String, String> someMap;
    private Set<String> someSet;

    public void init() {
        log.info(" ComplexObject init");
    }

    public void destroy() {
        log.info("ComplexObject destroy");
    }

    public ComplexObject setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
        return this;
    }

    public ComplexObject setSomeList(List<String> someList) {
        this.someList = someList;
        return this;
    }

    public ComplexObject setSomeMap(Map<String, String> someMap) {
        this.someMap = someMap;
        return this;
    }

    public ComplexObject setSomeSet(Set<String> someSet) {
        this.someSet = someSet;
        return this;
    }
}
