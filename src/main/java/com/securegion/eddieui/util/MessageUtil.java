package com.securegion.eddieui.util;

import com.securegion.eddieui.model.Message;

import java.util.Map;

public class MessageUtil {
    public static <T> T getParam(Message message, String key, T defaultVal) {
        Map<String, Object> data = (Map<String, Object>) message.getData();
        return getParam(data, key, defaultVal);
    }

    public static <T> T getParam(Map<String, Object> data, String key, T defaultVal) {
        if (data == null) return defaultVal;
        if (!data.containsKey(key)) return defaultVal;
        T res = (T)(data.get(key));
        return res;
    }
}
