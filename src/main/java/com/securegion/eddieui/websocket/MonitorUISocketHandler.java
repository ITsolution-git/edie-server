package com.securegion.eddieui.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Cheng on 5/6/17.
 */

@Service
public class MonitorUISocketHandler extends TextWebSocketHandler {
//    @Autowired MonitorUISocketService monitorUISocketService;
//    @Autowired SocketHandler socketController;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
//        monitorUISocketService.addUISession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        monitorUISocketService.removeUISession(session);
        super.afterConnectionClosed(session, status);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        socketController.handleUIMessage(session, message.getPayload());
    }
}
