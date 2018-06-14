package com.securegion.eddieui.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Cheng on 5/5/17.
 */

@Service
public class AgentSocketHandler extends TextWebSocketHandler {
//    @Autowired AgentSocketService agentSocketService;
//    @Autowired SocketHandler socketController;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
//        agentSocketService.addAgentSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        agentSocketService.removeAgentSession(session);
        super.afterConnectionClosed(session, status);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        socketController.handleAgentMessage(session, message.getPayload());
    }
}
