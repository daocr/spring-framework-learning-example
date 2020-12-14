package com.huilong.chapter4.service.impl;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloServiceImpl implements HelloService, InitializingBean, DisposableBean {


    @Override
    public void SayHello(String name) {

    }

    /**
     * 等价写法
     * 1、使用 @PostConstruct 注解
     * 2、在 xml bean 标签 init-method="init" 属性中指定
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        log.info(" HelloService  InitializingBean 初始化");
    }

    /**
     * 等价写法
     * 1、使用  @PreDestroy 注解
     * 2、在 xml bean 标签  destroy-method="destroy" 属性中指定
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" HelloService  DisposableBean 销毁");
    }
}
