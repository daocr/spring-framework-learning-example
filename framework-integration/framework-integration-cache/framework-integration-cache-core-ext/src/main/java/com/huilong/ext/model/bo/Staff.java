/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-core-ext
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ext.model.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工信息
 *
 * @author daocr
 * @date 2021/1/10
 */
@Data

public class Staff implements Serializable {

    private Integer id;

    private String name;

    // 国家
    private String country;

    private Integer age;

}
