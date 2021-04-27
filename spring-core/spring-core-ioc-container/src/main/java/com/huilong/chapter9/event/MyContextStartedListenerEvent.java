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
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 容器启动完成事件
 *
 * @author daocr
 * @date 2020/12/18
 */
@Component
@Slf4j
public class MyContextStartedListenerEvent implements ApplicationListener<ContextStartedEvent> {


    /**
     * 触发时机
     *
     * @param event
     * @see AbstractApplicationContext#start()
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {

        log.info("触发容器启动完成事件 ContextStartedEvent ");
    }
}
