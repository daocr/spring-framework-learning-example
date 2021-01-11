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

import java.time.Duration;
import java.util.List;

/**
 * spring mvc 配置
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
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        log.info("配置  configurePathMatch");

    }

    /**
     * 协商返回内容
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
     * 配置回调拦截器      ：{@link AsyncSupportConfigurer#registerCallableInterceptors(org.springframework.web.context.request.async.CallableProcessingInterceptor...)}
     * 配置               ：{@link AsyncSupportConfigurer#registerDeferredResultInterceptors(org.springframework.web.context.request.async.DeferredResultProcessingInterceptor...)}
     * 配置线程池          ：{@link  AsyncSupportConfigurer#setTaskExecutor(org.springframework.core.task.AsyncTaskExecutor)}
     * 配置默认超时时间     ：{@link AsyncSupportConfigurer#setDefaultTimeout(long)}
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        log.info("添加拦截器 addInterceptors");
        registry.addInterceptor(new MyInterception());

    }

    /**
     * 配置静态资源
     * xml 配置
     * <pre class=codd>
     *          <mvc:resources mapping="/resources/**" location="/public, classpath:/static/" cache-period="31556926" />
     *  </pre>
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }

    /**
     * 跨域设置
     * <p>
     * xml 配置
     *
     * <pre class=code>
     *          <mvc:cors>
     *
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

        registry.addMapping("/api/**")
                .allowedOrigins("https://domain2.com")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }

    /**
     * 添加无业务逻辑的调整，例如设置主页
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("/index");
    }

    /**
     * 视图解析器
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {


    }

    /**
     * 请求参数解析器
     *
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {


    }

    /**
     * 返回参数处理
     *
     * @param handlers
     */

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    /**
     * 配置请求数据格式转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     * 配置请求数据格式转换
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     * 配置异常处理器
     *
     * @param resolvers
     */

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    /**
     * 配置异常处理器
     *
     * @param resolvers
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    /**
     * 配置数据验证
     *
     * <pre class=code>
     *          <mvc:annotation-driven validator="globalValidator"/>
     * </pre>
     *
     * @return
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
