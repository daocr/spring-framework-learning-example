package com.huilong.socket.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

/**
 * 二进制内容
 * @author daocr
 * @date 2021/1/21
 */
@Controller
public class MyBinaryWebSocketHandler extends BinaryWebSocketHandler {

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        super.handleBinaryMessage(session, message);
    }
}
