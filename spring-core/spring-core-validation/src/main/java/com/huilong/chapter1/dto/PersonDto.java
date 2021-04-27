/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-validation
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author daocr
 * @date 2020/12/19
 */
@Data
public class PersonDto {

    @NotNull
    @Max(value = 3)
    private Integer age;
}
