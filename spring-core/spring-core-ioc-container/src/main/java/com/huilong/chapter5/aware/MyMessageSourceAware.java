/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * 处理国际化
 *
 * @author daocr
 * @date 2020/12/14
 */
@Component
@Slf4j
public class MyMessageSourceAware implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {

        this.messageSource=messageSource;

        log.info(" MessageSource 处理国际化 {}" ,messageSource);

    }
}
