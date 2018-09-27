package com.securegion.eddieui.messaging.commands;


import com.securegion.eddieui.model.Message;

import java.util.Map;

public interface Command {
    Object run(String method, Map<String, Object> params, Message message);
}
