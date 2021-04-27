/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-sp-el
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 员工
 */
@ToString
@Data
public class Employee {

    private String name;

    private float salary;

}