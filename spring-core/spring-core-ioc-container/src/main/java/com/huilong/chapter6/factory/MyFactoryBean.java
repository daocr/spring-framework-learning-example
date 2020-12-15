package com.huilong.chapter6.factory;

import com.huilong.chapter6.service.HelloService;
import com.huilong.chapter6.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 用  FactoryBean 创建 bean
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class MyFactoryBean implements FactoryBean<HelloService> {
    @Override
    public HelloService getObject() throws Exception {

        HelloServiceImpl helloService = new HelloServiceImpl();

        log.info("实例化 HelloServiceImpl 完成 {}", helloService);

        return helloService;
    }

    @Override
    public Class<HelloService> getObjectType() {
        return HelloService.class;
    }
}
