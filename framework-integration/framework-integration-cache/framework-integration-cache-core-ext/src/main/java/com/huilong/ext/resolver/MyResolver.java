/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-core-ext
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ext.resolver;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author daocr
 * @date 2021/4/23
 */
@Component("myResolver")
public class MyResolver implements CacheResolver {
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        return null;
    }
}
