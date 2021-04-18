package com.huilong.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.validation.Validation;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author daocr
 * @date 2021/1/25
 */
@Slf4j
public class BeanConfig {

    /**
     * 配置 thymeleaf 模板解析器
     */
    @Configuration
    public static class ConfigThymeleafViewResolver {

        @Bean
        public SpringResourceTemplateResolver getSpringResourceTemplateResolver(@Autowired ApplicationContext applicationContext) {
            SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
            springResourceTemplateResolver.setApplicationContext(applicationContext);
            springResourceTemplateResolver.setPrefix("/WEB-INF/templates/");
            springResourceTemplateResolver.setSuffix(".html");
            springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
            springResourceTemplateResolver.setCacheable(false);
            springResourceTemplateResolver.setCharacterEncoding("UTF-8");
            return springResourceTemplateResolver;
        }

        @Bean
        public SpringTemplateEngine getSpringTemplateEngine(@Autowired SpringResourceTemplateResolver springResourceTemplateResolver) {

            SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
            springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
            springTemplateEngine.setEnableSpringELCompiler(true);
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


    /**
     * 数据校验配置
     */
    @Configuration
    public static class Validator {

        /**
         * aop 拦截  {@link Validated} 注解
         *
         * @return
         */
        @Bean
        @Primary
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
            postProcessor.setBeforeExistingAdvisors(true);
            postProcessor.setProxyTargetClass(true);

            javax.validation.Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

            postProcessor.setValidator(validator);
            return postProcessor;
        }
    }


    /**
     * 国际化配置
     * <p>
     * {@link LocaleChangeInterceptor} 基于请求参数
     * <p>
     * {@link MyWebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)}
     */
    @Configuration
    public static class I18n {


        /**
         * 配置 国际化文件
         * <p>
         * bean name 必须要是  messageSource 原因： {@link AbstractApplicationContext#initMessageSource()}
         *
         * @return
         */
        @Bean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
        public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {

            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setDefaultEncoding("utf-8");
            messageSource.setUseCodeAsDefaultMessage(true);
            messageSource.setBasenames("classpath:i18n/message");

            return messageSource;
        }


        /**
         * 注意 bean 的名称替不能换成其他名字，必须叫 localeResolver
         * <p>
         * 存储区域设置信息 SessionLocaleResolver类通过一个预定义会话名将区域化信息存储在会话中 从session判断用户语言defaultLocale
         * <p>
         * {@link org.springframework.web.servlet.i18n.CookieLocaleResolver} 基于 cookie
         * {@link org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver}  基于 header
         * <p>
         * <p>
         * {@link SessionLocaleResolver} 基于会话
         *
         * @return
         */
        @Bean(name = "localeResolver")
        public LocaleResolver getLocaleResolver() {
            SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
            sessionLocaleResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
            return sessionLocaleResolver;
        }


    }

}
