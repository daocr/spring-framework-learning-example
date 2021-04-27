/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
@ApiModel(description = "员工")
public class Staff implements Serializable {

    @ApiModelProperty(value = "编号")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;

}
