package com.huilong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.ArrayList;

/**
 * @author daocr
 * @date 2021/1/25
 */

public class BeanConfig {

    /**
     * 配置 thymeleaf 模板解析器
     */
    @Configuration
    public static class ConfigThymeleafViewResolver {

        @Bean
        public SpringResourceTemplateResolver getSpringResourceTemplateResolver() {
            SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
            springResourceTemplateResolver.setPrefix("/WEB-INF/templates/");
            springResourceTemplateResolver.setSuffix(".html");
            springResourceTemplateResolver.setTemplateMode("HTML5");
            springResourceTemplateResolver.setCacheable(false);
            springResourceTemplateResolver.setCharacterEncoding("UTF-8");
            return springResourceTemplateResolver;

        }

        @Bean
        public SpringTemplateEngine getSpringTemplateEngine(@Autowired SpringResourceTemplateResolver springResourceTemplateResolver) {

            SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
            springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
            return springTemplateEngine;
        }

        @Bean
        public ThymeleafViewResolver getThymeleafViewResolver(@Autowired SpringTemplateEngine springTemplateEngine) {

            ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
            thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
            thymeleafViewResolver.setCharacterEncoding("utf-8");
            return thymeleafViewResolver;
        }
    }


    /**
     * 配置 Jackson 解析
     */
    @Configuration
    public static class ConfigJsonConverter {

        @Bean
        public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
            RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
            ArrayList<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
            httpMessageConverters.add(new MappingJackson2HttpMessageConverter());
            requestMappingHandlerAdapter.setMessageConverters(httpMessageConverters);
            return requestMappingHandlerAdapter;
        }

        @Bean
        public MappingJackson2JsonView getMappingJackson2JsonView() {
            MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
            mappingJackson2JsonView.setContentType("application/json");
            return mappingJackson2JsonView;
        }

    }

    /**
     * 配置文件上传
     */
    @Configuration
    public static class ConfigFileUpload {

        @Bean
        public CommonsMultipartResolver getCommonsMultipartResolver() {
            return new CommonsMultipartResolver();
        }
    }
}
