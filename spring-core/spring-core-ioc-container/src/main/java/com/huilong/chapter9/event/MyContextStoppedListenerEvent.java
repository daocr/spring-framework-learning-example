/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter9.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 容器停止事件，会触发bean 的销毁
 *
 * @author daocr
 * @date 2020/12/18
 */
@Slf4j
@Component
public class MyContextStoppedListenerEvent implements ApplicationListener<ContextStoppedEvent> {


    /**
     * 触发时机
     *
     * @param event
     * @see AbstractApplicationContext#stop()
     */
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {

        log.info("触发容器停止事件 ContextStoppedEvent");

    }
}
