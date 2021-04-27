/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.controller.i18n;

import com.huilong.model.bo.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * i18n  国际化配置
 *
 * @author daocr
 * @date 2021/2/7
 */
@Api(tags = "国际化")
@RestController
@RequestMapping("/springmvc/i18n")
public class I18nController {


    /**
     * 国际化
     *
     * @param lang
     * @return
     */
    @GetMapping("/world")
    @Operation(summary = "国际化", description = "lang 参数控制国际化 " +
            "\n zh_CN ：中文 \nen_US：英文")
    public R<String> i18n(@RequestParam(name = "lang", defaultValue = "zh_CN") String lang, HttpServletRequest request) {


        RequestContext requestContext = new RequestContext(request);
        String world = requestContext.getMessage("world");

        return R.success(world);
    }


}
