/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-ehcache-2x
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ehcache2.config;

import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 配置  ehcache 2.x 版本
 *
 * @author daocr
 * @date 2021/4/23
 */
@Configuration
@EnableCaching
public class EhcacheConfig {

    /**
     * 配置  ehcache 2.x 版本
     *
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ClassPathResource classPathResource = new ClassPathResource("ehcache.xml");
        ehCacheManagerFactoryBean.setConfigLocation(classPathResource);
        return ehCacheManagerFactoryBean;
    }

    @Bean("myCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(@Autowired CacheManager cacheManager) {

        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager);

        return ehCacheCacheManager;
    }

}
