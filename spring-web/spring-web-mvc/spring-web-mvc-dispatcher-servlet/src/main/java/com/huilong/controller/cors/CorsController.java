/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.controller.cors;

import com.huilong.config.MyWebMvcConfigurer;
import com.huilong.model.bo.Staff;
import com.huilong.utils.MockUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * 跨域配置
 * <p>
 * 全局跨域配置 {@link MyWebMvcConfigurer#addCorsMappings(CorsRegistry)}
 *
 * @author daocr
 * @date 2021/1/11
 */
@Slf4j
@RestController
@Api(tags = "跨域 配置 学习")
@RequestMapping("/springmvc/cors")
public class CorsController {

    /**
     * 允许所有的请求
     *
     * @return
     */
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/cors-all")
    public Staff corsAll(@RequestHeader(name = "Referer", required = false) String referer) {

        log.info("referer: {}", referer);
        Staff staff = MockUtils.mockDynamic();
        return staff;
    }

    /**
     * 只允许 domain2.com 域名过来的请求
     *
     * @return
     */
    @CrossOrigin(origins = {"https://domain2.com"})
    @GetMapping("/allow-domain2")
    public Staff allowDomain2(@RequestHeader(name = "Referer", required = false) String referer) {

        log.info("referer: {}", referer);
        Staff staff = MockUtils.mockDynamic();
        return staff;

    }

}
