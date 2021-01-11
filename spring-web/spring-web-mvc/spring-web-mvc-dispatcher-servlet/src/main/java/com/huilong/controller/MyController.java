package com.huilong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制层
 *
 * @author daocr
 * @date 2021/1/8
 */
@Slf4j
@Controller
@RequestMapping("/springmvc")
public class MyController {

    @RequestMapping("/index")
    public String index() {

        // 从thread local 中获取 上下文
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        WebApplicationContext webApplicationContext = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        log.info("request url: {}", request.getRequestURI());
        return "index";
    }
}
