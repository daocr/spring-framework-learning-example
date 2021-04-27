/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.controller.annotated;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 属性编辑器
 *
 * @author daocr
 * @date 2021/1/21
 */

@Slf4j
@RestController
@Api(tags = "属性编辑器")
@RequestMapping("/springmvc/request-mapping")
public class DataBinderController {


}
