package com.securegion.eddieui.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class EventSocketHandler extends TextWebSocketHandler {
//    @Autowired EventSocketService eventSocketService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        eventSocketService.addSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        eventSocketService.removeSession(session);
    }
}
