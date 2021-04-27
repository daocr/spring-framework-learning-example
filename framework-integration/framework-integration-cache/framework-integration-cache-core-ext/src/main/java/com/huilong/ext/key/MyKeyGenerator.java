/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-core-ext
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ext.key;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 缓存 名称 生成 策略
 *
 * @author daocr
 * @date 2021/4/23
 */
@Component("myKeyGenerator")
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {

        return null;
    }
}
