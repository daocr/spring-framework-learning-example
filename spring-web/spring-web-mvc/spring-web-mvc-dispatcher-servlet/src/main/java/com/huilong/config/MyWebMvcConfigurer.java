package com.huilong.config;

import com.huilong.Intercepter.MyInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import java.time.Duration;
import java.util.List;

/**
 * spring mvc 配置
 * <p>
 * 加载时机
 * 1、实例化
 * {@link org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration}
 * <p>
 * <p>
 * 2、实例化 {@link WebMvcConfigurationSupport} 类标有 @bean 注解的方法
 *
 * @author daocr
 * @date 2021/1/10
 */
@Configuration
@EnableWebMvc
@Slf4j
public class MyWebMvcConfigurer implements WebMvcConfigurer {


    /**
     * 配置映射关系
     * 调用关系
     * {@link WebMvcConfigurationSupport#mvcResourceUrlProvider()}
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        /**
         *  开启  @MatrixVariable 注解的识别
         *  如果是 xml，请用 <mvc:annotation-driven enable-matrix-variables="true"/>
         */
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);

        log.info("配置  configurePathMatch");

    }

    /**
     * 协商返回内容
     * <p>
     * 加载时机：{@link WebMvcConfigurationSupport#mvcContentNegotiationManager()}
     *
     * <p>
     * xml 配置
     * <pre class=code>
     *     <mvc:annotation-driven content-negotiation-manager="contentNegotiationManager"/>
     *
     *      <bean id="contentNegotiationManager" class="org.springframework.web.accept.ContentNegotiationManagerFactoryBean">
     *         <property name="mediaTypes">
     *             <value>
     *                 json=application/json
     *                 xml=application/xml
     *             </value>
     *         </property>
     *      </bean>
     * </pre>
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        log.info("配置  configureContentNegotiation");
//        configurer.mediaType("json", MediaType.APPLICATION_JSON);
//        configurer.mediaType("xml", MediaType.APPLICATION_XML);
    }

    /**
     * 配置异步请求
     * <p>
     * <p>
     * 加载时机
     * {@link WebMvcConfigurationSupport#requestMappingHandlerAdapter(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.validation.Validator)}
     * {@link WebMvcConfigurationSupport#getAsyncSupportConfigurer()}
     * <p>
     * <p>
     * 配置回调拦截器      ：{@link AsyncSupportConfigurer#registerCallableInterceptors(org.springframework.web.context.request.async.CallableProcessingInterceptor...)}
     * 配置               ：{@link AsyncSupportConfigurer#registerDeferredResultInterceptors(org.springframework.web.context.request.async.DeferredResultProcessingInterceptor...)}
     * 配置线程池          ：{@link  AsyncSupportConfigurer#setTaskExecutor(org.springframework.core.task.AsyncTaskExecutor)}
     * 配置默认超时时间     ：{@link AsyncSupportConfigurer#setDefaultTimeout(long)}
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        log.info("configureAsyncSupport");
    }


    /**
     * 加载时机
     * {@link WebMvcConfigurationSupport#defaultServletHandlerMapping()}
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        log.info("configureDefaultServletHandling");
    }

    /**
     * 加载时机
     * <p>
     * {@link WebMvcConfigurationSupport#mvcConversionService()}
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

        log.info("addFormatters");
    }

    /**
     * 添加拦截器
     * 加载时机：
     * {@link WebMvcConfigurationSupport#requestMappingHandlerMapping(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * <p>
     * {@link WebMvcConfigurationSupport#getInterceptors(org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        log.info("添加拦截器 addInterceptors");
        registry.addInterceptor(new MyInterception()).addPathPatterns("/");

    }

    /**
     * 配置静态资源
     * 加载时机：
     * {@link WebMvcConfigurationSupport#resourceHandlerMapping(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * <p>
     * {@link DelegatingWebMvcConfiguration#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)}
     * <p>
     * xml 配置
     * <pre class=codd>
     *          <mvc:resources mapping="/resources/**" location="/public, classpath:/static/" cache-period="31556926" />
     *  </pre>
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("WEB-INF/static/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));

        // 添加 swagger-ui 3.x 的静态文件处理，网上目前大多数是 2.x 的配置方法，需要注意配置
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

    /**
     * 跨域设置
     * <p>
     * xml 配置
     * <p>
     * 加载时机：
     * <p>
     * {@link WebMvcConfigurationSupport#requestMappingHandlerMapping(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * {@link WebMvcConfigurationSupport#getCorsConfigurations()}
     *
     * <pre class=code>
     *          <mvc:cors>
     *              <mvc:mapping path="/api/**"
     *                  allowed-origins="https://domain1.com, https://domain2.com"
     *                  allowed-methods="GET, PUT"
     *                  allowed-headers="header1, header2, header3"
     *                  exposed-headers="header1, header2" allow-credentials="true"
     *                  max-age="123" />
     *
     *                  <mvc:mapping path="/resources/**"  allowed-origins="https://domain1.com" />
     *
     *          </mvc:cors>
     * </pre>
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

//        registry.addMapping("/api/**")
//                .allowedOrigins("https://domain2.com")
//                .allowedMethods("PUT", "DELETE")
//                .allowedHeaders("header1", "header2", "header3")
//                .exposedHeaders("header1", "header2")
//                .allowCredentials(true).maxAge(3600);


    }

    /**
     * 添加无业务逻辑的调整，例如设置主页
     * 加载时机
     * {@link WebMvcConfigurationSupport#viewControllerHandlerMapping(org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * {@link DelegatingWebMvcConfiguration#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)}
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("/index");

        registry.addViewController("/websokect").setViewName("/websokect/webSocketHome");
    }

    /**
     * 视图解析器
     * 加载时机
     * {@link WebMvcConfigurationSupport#mvcViewResolver(org.springframework.web.accept.ContentNegotiationManager)}
     * {@link WebMvcConfigurationSupport#configureViewResolvers(org.springframework.web.servlet.config.annotation.ViewResolverRegistry)}
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        log.info("configureViewResolvers");

    }

    /**
     * 请求参数解析器
     * <p>
     * 加载时机
     * <p>
     * {@link WebMvcConfigurationSupport#requestMappingHandlerAdapter(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.validation.Validator)}
     * s    * <p>
     * {@link WebMvcConfigurationSupport#getArgumentResolvers()}
     *
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        log.info("addArgumentResolvers");
    }

    /**
     * 返回参数处理
     * 加载时机
     * {@link WebMvcConfigurationSupport#requestMappingHandlerAdapter(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.validation.Validator)}
     * {@link WebMvcConfigurationSupport#getReturnValueHandlers()}
     *
     * @param handlers
     */

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

        log.info("addReturnValueHandlers");
    }


    /**
     * 加载时机
     * {@link WebMvcConfigurationSupport#requestMappingHandlerAdapter(org.springframework.web.accept.ContentNegotiationManager, org.springframework.format.support.FormattingConversionService, org.springframework.validation.Validator)}
     * {@link WebMvcConfigurationSupport#getConfigurableWebBindingInitializer(org.springframework.format.support.FormattingConversionService, org.springframework.validation.Validator)}
     *
     * @return
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        log.info("getMessageCodesResolver");
        return null;
    }

    /**
     * 配置请求数据格式转换
     * 加载时机
     * {@link WebMvcConfigurationSupport#routerFunctionMapping(org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * {@link WebMvcConfigurationSupport#getMessageConverters()}
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        log.info("configureMessageConverters");
    }

    /**
     * 配置请求数据格式转换
     * <p>
     * 加载时机
     * {@link WebMvcConfigurationSupport#routerFunctionMapping(org.springframework.format.support.FormattingConversionService, org.springframework.web.servlet.resource.ResourceUrlProvider)}
     * {@link WebMvcConfigurationSupport#getMessageConverters()}
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        log.info("extendMessageConverters");
    }

    /**
     * 配置异常处理器
     * <p>
     * 加载时机
     * {@link WebMvcConfigurationSupport#handlerExceptionResolver(org.springframework.web.accept.ContentNegotiationManager)}
     * {@link DelegatingWebMvcConfiguration#configureHandlerExceptionResolvers(java.util.List)}
     *
     * @param resolvers
     */

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

        log.info("configureHandlerExceptionResolvers");
    }

    /**
     * 配置异常处理器
     * <p>
     * <p>
     * 加载时机
     * {@link WebMvcConfigurationSupport#handlerExceptionResolver(org.springframework.web.accept.ContentNegotiationManager)}
     * {@link DelegatingWebMvcConfiguration#extendHandlerExceptionResolvers(java.util.List)}
     *
     * @param resolvers
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        log.info("extendHandlerExceptionResolvers");
    }

    /**
     * 配置数据验证
     * <p>
     * 加载时机
     * {@link WebMvcConfigurationSupport#mvcValidator()}
     * {@link WebMvcConfigurationSupport#getValidator()}
     *
     * <pre class=code>
     *          <mvc:annotation-driven validator="globalValidator"/>
     * </pre>
     *
     * @return
     */
    @Override
    public Validator getValidator() {
        log.info("getValidator");
        return null;
    }




}
