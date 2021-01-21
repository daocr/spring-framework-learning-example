package com.huilong.socket.config;

import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/**
 * 配置
 *
 * @author daocr
 * @date 2021/1/21
 */
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {

    }

    @Override
    public void configureClientInboundChannel(org.springframework.messaging.simp.config.ChannelRegistration registration) {

    }

    @Override
    public void configureClientOutboundChannel(org.springframework.messaging.simp.config.ChannelRegistration registration) {

    }

    @Override
    public void addArgumentResolvers(List<org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    @Override
    public boolean configureMessageConverters(List<org.springframework.messaging.converter.MessageConverter> messageConverters) {
        return false;
    }

    @Override
    public void configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry registry) {

    }
}
