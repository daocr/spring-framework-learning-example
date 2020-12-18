package com.huilong.chapter8.config;

import com.huilong.chapter8.service.HelloService8;
import com.huilong.chapter8.service.impl.HelloService8Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

/**
 * 模拟不同环境的配置
 *
 * @author daocr
 * @date 2020/12/18
 */
@Configuration
@Slf4j
public class BeanConfig {


    @Bean
    @Profile("dev")
    public HelloService8 helloService8Dev() {

        log.info("{}环境初始化", "dev");
        return new HelloService8Impl();
    }

    @Bean
    @Profile("ubt")
    public HelloService8 helloService8Ubt() {
        log.info("{}环境初始化", "ubt");
        return new HelloService8Impl();
    }

}
