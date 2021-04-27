/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-ehcache-3x
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ehcache3.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

/**
 * 配置  ehcache 3.x 版本
 *
 * @author daocr
 * @date 2021/4/23
 */
@Configuration
@EnableCaching
public class EhcacheConfig {


    /**
     * 配置  ehcache 3.x 版本
     *
     * @return
     */
    @Bean("myEhCacheCacheManager")
    public JCacheCacheManager jCacheCacheManager() throws URISyntaxException {

        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        CachingProvider provider = Caching.getCachingProvider();

        CacheManager eh107CacheManager = provider.getCacheManager(getClass().getResource("/ehcache.xml").toURI(),
                getClass().getClassLoader());

        jCacheCacheManager.setCacheManager(eh107CacheManager);
        return jCacheCacheManager;
    }


}
