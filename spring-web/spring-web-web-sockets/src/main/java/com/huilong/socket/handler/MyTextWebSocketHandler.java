/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-web-sockets
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.socket.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 普通文本内容
 *
 * @author daocr
 * @date 2021/1/21
 */
@Controller
public class MyTextWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        super.handleBinaryMessage(session, message);
    }
}
