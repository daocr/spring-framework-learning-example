package com.huilong.chapter9.service.impl;

import com.huilong.chapter9.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件上下文，提供了事件管理的功能
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class MyApplicationEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
        log.info("提供事件管理上下文成功 {}", applicationEventPublisher);

    }

    /**
     * 触发事件
     *
     * @param customEvent
     */
    public void trigger(CustomEvent customEvent) {
        publisher.publishEvent(customEvent);
    }

}
