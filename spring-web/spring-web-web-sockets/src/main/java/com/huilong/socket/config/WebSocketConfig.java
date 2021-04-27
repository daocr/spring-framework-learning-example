/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-web-sockets
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.socket.config;

import com.huilong.socket.handler.MyTextWebSocketHandler;
import com.huilong.socket.interceptor.MyHandshakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.SockJsServiceRegistration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * @author daocr
 * @date 2021/1/21
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        SockJsServiceRegistration sockJsServiceRegistration = registry.addHandler(new MyTextWebSocketHandler(), "/websocket-simple")

                // 添加拦截器
                .addInterceptors(new MyHandshakeInterceptor())
                // 运行来源配置
//                .setAllowedOrigins("https://mydomain.com")
                .setAllowedOrigins("*")

                // 启用 sockJs
                .withSockJS();


    }


    /**
     * 创建 web socket 容器
     *
     * @return
     */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);

        return container;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(
//                new DispatcherServlet(), "/");
//        registration.setAsyncSupported(true);
//        return registration;
//    }


////     使用jetty  需要配置
//
//    @Bean
//    public DefaultHandshakeHandler handshakeHandler() {
//
//        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
//        policy.setInputBufferSize(8192);
//        policy.setIdleTimeout(600000);
//
//        return new DefaultHandshakeHandler(
//                new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
//    }


}
