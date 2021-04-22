package com.huilong.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.cache.StandardCacheManager;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * ThymeleafSpringConfig
 */
@Configuration
public class ThymeleafSpringConfig
        implements ApplicationContextAware, WebMvcConfigurer {

    private ApplicationContext applicationContext;


    /**
     * 国际化配置
     *
     * @return
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBeanClassLoader(ThymeleafSpringConfig.class.getClassLoader());
        messageSource.setBasename("/i18n/message");
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }



    /* ******************************************************************* */
    /*  GENERAL CONFIGURATION ARTIFACTS                                    */
    /*  Static Resources, i18n Messages, Formatters (Conversion Service)   */
    /* ******************************************************************* */

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }


    /* ****************************************************************                          */
    /*  THYMELEAF-SPECIFIC ARTIFACTS                                                             */
    /*  TemplateResolver <- TemplateEngine <- ViewResolver                                       */
    /*  xml 配置 查看 spring-web-mvc-thymeleaf/src/main/webapp/WEB-INF/springmvc-servlet.xml      */
    /*  放开注释即可                                                                               */
    /* ****************************************************************                          */

    /**
     * 配置 thymeleaf Template 相关信息
     *
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        //文件编码
        templateResolver.setCharacterEncoding("utf-8");
        // spring 上下文
        templateResolver.setApplicationContext(this.applicationContext);
        // 模板目录
        templateResolver.setPrefix("/WEB-INF/templates/");
        // 模板后缀
        templateResolver.setSuffix(".html");
        // 模板模式
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // 模板缓存
        templateResolver.setCacheable(true);
        templateResolver.getCacheablePatternSpec().addPattern("/users/*");
        // 模板缓存时间
        templateResolver.setCacheTTLMs(60000L);

//        // 模板别名
//        templateResolver.addTemplateAlias("adminHome","profiles/admin/home");
//        templateResolver.setTemplateAliases(aliasesMap);


        return templateResolver;
    }

    /**
     * 配置 thymeleaf 渲染器
     *
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);

        // 设置 国际化文件
//        templateEngine.setMessageSource(messageSource());
//        templateEngine.setTemplateEngineMessageSource();
//        templateEngine.setRenderHiddenMarkersBeforeCheckboxes();
//        templateEngine.setDialect();
//        templateEngine.setDialectsByPrefix();
//        templateEngine.setDialects();
//        templateEngine.setAdditionalDialects();
//        templateEngine.setTemplateResolvers();

        // 设置缓存 Default is 200
        StandardCacheManager cacheManager = new StandardCacheManager();
        cacheManager.setTemplateCacheMaxSize(100);
        templateEngine.setCacheManager(cacheManager);


        return templateEngine;
    }

    /**
     * 配置  thymeleaf 作为spring 视图解析
     *
     * @return
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

}