package com.huilong.chapter4.service.impl;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Service("helloServiceV2")
public class HelloServiceV2Impl implements HelloService {

    @Override
    public void SayHello(String name) {

        log.info("你好：{} 实现类：{}", name,this.getClass().getName());

        if ("赵六".equals(name)) {
            throw new RuntimeException();
        }

    }
}
