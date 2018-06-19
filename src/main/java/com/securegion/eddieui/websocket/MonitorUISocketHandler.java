package com.securegion.eddieui.websocket;

import com.securegion.eddieui.hook.IMHook;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cheng on 5/6/17.
 */

@Log4j2
@Service
public class MonitorUISocketHandler extends TextWebSocketHandler {
    @Autowired IMHook imHook;

    private List<WebSocketSession> uiSessionList = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        uiSessionList.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        uiSessionList.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        log.info("UISocket Message Received: " + msg);
    }
}
