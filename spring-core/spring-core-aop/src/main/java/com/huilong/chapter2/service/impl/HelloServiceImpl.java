package com.huilong.chapter2.service.impl;

import com.huilong.chapter2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public void SayHello(String name) {

        log.info("你好：{}", name);

        if ("赵六".equals(name)) {
            throw new RuntimeException();
        }

    }
}
