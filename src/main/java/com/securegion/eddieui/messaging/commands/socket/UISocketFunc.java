package com.securegion.eddieui.messaging.commands.socket;

import com.securegion.eddieui.messaging.commands.Command;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.util.MessageUtil;
import com.securegion.eddieui.websocket.WebSocketConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Log4j2
@Service
public class UISocketFunc implements Command {
    @Autowired WebSocketConfig webSocket;
    @Override
    public Object run(String method, Map<String, Object> params, Message message) {
        switch (method) {
            case "pushIncidents":
                return pushIncidents.apply(MessageUtil.getParam(message, "incidents", null));
            default:
                log.error("Method not found: " + method);
        }
        return null;
    }

    Function<Object, String> pushIncidents = (data) -> {
        webSocket.send("incidents", data);
        return "";
    };
}
