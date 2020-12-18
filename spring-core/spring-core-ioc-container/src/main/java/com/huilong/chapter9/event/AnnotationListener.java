package com.huilong.chapter9.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 注解监听事件
 *
 * @author daocr
 * @date 2020/12/18
 */
@Slf4j
@Component
public class AnnotationListener {

    @EventListener(value = {CustomEvent.class}, condition = "#customEvent.eventName !='黑名单' ")
    public void processOrdinaryEvent(CustomEvent customEvent) {
        log.info("接收到普通事件： {} 来源 {}", customEvent.getEventName(), customEvent.getSource());
    }

    @Async
    @EventListener(value = {CustomEvent.class}, condition = "#customEvent.eventName =='黑名单' ")
    public void processBlockedListEvent(CustomEvent customEvent) {
        log.info("接收到黑名单事件： {} 来源 {}", customEvent.getEventName(), customEvent.getSource());
    }


}
