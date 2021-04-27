/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-core-ext
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ext.model.param;

import lombok.Data;

import java.io.Serializable;


/**
 * @author daocr
 * @date 2021/1/10
 */
@Data

public class StaffParam implements Serializable {


    /**
     * 员工名称
     */
    private String name;

    /**
     * 部门名字
     */
    private String department;


}
