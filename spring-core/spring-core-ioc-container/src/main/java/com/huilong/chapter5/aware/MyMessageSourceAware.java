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
