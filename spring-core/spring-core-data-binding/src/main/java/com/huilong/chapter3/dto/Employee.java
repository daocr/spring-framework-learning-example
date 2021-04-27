/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-data-binding
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter3.dto;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 员工
 */
@Slf4j
@ToString
@Data
public class Employee {

    private String name;

    private float salary;

    private Date birthday;

    public Employee setBirthday(Date birthday) {
        log.info("设置生日成功 {}", birthday);
        this.birthday = birthday;
        return this;
    }
}