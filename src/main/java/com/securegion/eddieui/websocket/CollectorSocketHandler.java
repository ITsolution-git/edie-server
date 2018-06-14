package com.securegion.eddieui.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Cheng on 7/10/17.
 */
@Service
public class CollectorSocketHandler extends TextWebSocketHandler {

//    @Autowired CollectorSocketService collectorSocketService;
//    @Autowired SocketHandler socketController;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
//        collectorSocketService.addCollectorSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
//        collectorSocketService.removeCollectorSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        socketController.handleCollectorMessage(session, message.getPayload());
    }
}
