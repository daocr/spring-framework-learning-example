/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-thymeleaf
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.config;

import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

/**
 * xml 配置请查看
 *
 * @see spring-web/spring-web-mvc/spring-web-mvc-freemarker/src/main/webapp/WEB-INF/springmvc-servlet.xml
 * FreemarkerSpringConfig
 */
@Configuration
@EnableWebMvc
public class FreemarkerSpringConfig
        implements WebMvcConfigurer {

    private static final String CHARSET_UTF_8 = "UTF-8";


    /**
     * 配置 freeMarker 作为解析视图
     *
     * @return
     */
    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setCache(true);
        return viewResolver;
    }

    /**
     * 配置 FreeMarkerConfigurer
     *
     * @return
     * @throws TemplateException
     * @throws IOException
     */
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws TemplateException, IOException {

        // FreeMarker 引擎 配置
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setDefaultEncoding(CHARSET_UTF_8);
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/templates");


        return freeMarkerConfigurer;
    }


}