/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-caffeine
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.caffeine.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 配置  CaffeineConfig
 *
 * @author daocr
 * @date 2021/4/23
 */
@Configuration
@EnableCaching
public class CaffeineConfig {


    /**
     * 配置 缓存管理器
     *
     * @return
     */
    @Bean("myCaffeineCacheManager")
    public SimpleCacheManager jCacheCacheManager(@Autowired @Qualifier("myCache") CaffeineCache cache) throws URISyntaxException {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(cache));
        return cacheManager;

    }

    /**
     * 配置 配置具体缓存库
     *
     * @return
     */

    @Bean("myCache")
    public CaffeineCache myConcurrentMap() {

        Cache<Object, Object> build = Caffeine.newBuilder().recordStats().expireAfterAccess(30, TimeUnit.MINUTES)
                .maximumSize(5).build();

        return new CaffeineCache("default", build);
    }


}
