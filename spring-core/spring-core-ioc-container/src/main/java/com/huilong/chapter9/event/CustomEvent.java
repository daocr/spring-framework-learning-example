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
