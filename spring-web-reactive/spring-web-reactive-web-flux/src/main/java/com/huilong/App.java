/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-reactive-web-flux
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
//package com.huilong;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.http.server.reactive.HttpHandler;
//import org.springframework.http.server.reactive.TomcatHttpHandlerAdapter;
//import org.springframework.web.reactive.DispatcherHandler;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.server.WebHandler;
//import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
//
//import javax.servlet.Servlet;
//import java.io.File;
//
//
///**
// * Hello world!
// */
//@Configuration
//@ComponentScan
//@EnableWebFlux
//public class App {
//
//    public static void main(String[] args) throws LifecycleException {
//
//        //1、 class path  加载配置
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
////
//        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(applicationContext).build();
//
//        Servlet servlet = new TomcatHttpHandlerAdapter(handler);
//        File base = new File(System.getProperty("java.io.tmpdir"));
//        Tomcat server = new Tomcat();
//        Context rootContext = server.addContext("", base.getAbsolutePath());
//        Tomcat.addServlet(rootContext, "main", servlet);
//        rootContext.addServletMappingDecoded("/", "main");
//        server.setHostname("localhost");
//        server.setPort(8080);
//        server.start();
//    }
//
//    @Bean
//    public WebHandler webHandler(ApplicationContext applicationContext) {
//        DispatcherHandler dispatcherHandler = new DispatcherHandler(applicationContext);
//        return dispatcherHandler;
//    }
//}
