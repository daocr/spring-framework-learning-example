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
