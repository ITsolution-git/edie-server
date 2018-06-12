package com.securegion.eddieui.util;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.data.domain.PageRequest;

import java.util.Base64;

public class PageRequestUtil {
    public static String serialize(PageRequest request) {
        return Base64.getEncoder().encodeToString(SerializationUtils.serialize(request));
    }

    public static PageRequest deserialize(String content) {
        return SerializationUtils.deserialize(Base64.getDecoder().decode(content));
    }
}
