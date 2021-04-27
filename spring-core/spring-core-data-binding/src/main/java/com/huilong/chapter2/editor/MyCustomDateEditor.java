/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-data-binding
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.editor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class MyCustomDateEditor extends PropertyEditorSupport {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public String getAsText() {
        log.info("call getAsText");
        return super.getAsText();
    }

    @SneakyThrows
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        log.info("调用 setAsText value : {}", text);

        Date parse = dateFormat.parse(text);

        setValue(parse);


    }
}
