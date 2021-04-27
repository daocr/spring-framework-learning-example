/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-thymeleaf
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
public class Staff implements Serializable {

    private String name;

    private String job;

    private Date birthday;

}
