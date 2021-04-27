/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-concurrent-map
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ehcache3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 配置  ConcurrentMapConfig
 *
 * @author daocr
 * @date 2021/4/23
 */
@Configuration
@EnableCaching
public class ConcurrentMapConfig {


    /**
     * 配置 缓存管理器
     *
     * @return
     */
    @Bean("myEhCacheCacheManager")
    public SimpleCacheManager jCacheCacheManager(@Autowired @Qualifier("myConcurrentMap") ConcurrentMapCache cache) throws URISyntaxException {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(cache));
        return simpleCacheManager;

    }

    /**
     * 配置 配置具体缓存库
     *
     * @return
     */

    @Bean("myConcurrentMap")
    public ConcurrentMapCacheFactoryBean myConcurrentMap() {
        ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        concurrentMapCacheFactoryBean.setName("my-cache");
        return concurrentMapCacheFactoryBean;
    }


}
