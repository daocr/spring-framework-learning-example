/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-validation
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1.dto;

import com.huilong.chapter1.group.Insert;
import com.huilong.chapter1.group.Update;
import com.huilong.chapter1.group.provider.MyDefaultGroupSequenceProvider;
import lombok.Data;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author daocr
 * @date 2020/12/19
 */
@Data
@GroupSequenceProvider(value = MyDefaultGroupSequenceProvider.class)
public class PersonDto {

    private Integer id;

    @NotNull(groups = Insert.class)
    @Max(value = 3)
    private Integer age;

    @NotNull(groups = Update.class)
    private String name;
}
