/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter9.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author daocr
 * @date 2020/12/18
 */
public class CustomEvent extends ApplicationEvent {
    private String eventName;

    public CustomEvent(Object source, String eventName) {
        super(source);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
}
