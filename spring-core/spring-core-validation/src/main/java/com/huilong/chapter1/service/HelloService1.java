/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-validation
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author daocr
 * @date 2020/12/14
 */

@Validated
public interface HelloService1 {
    void SayHello(@NotNull String name);
}
