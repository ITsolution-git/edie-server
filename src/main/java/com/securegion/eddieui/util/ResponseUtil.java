package com.securegion.eddieui.util;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    public static <T> T wrapResponse(T data, HttpServletResponse res) {
        if (data != null) return data;
        res.setStatus(500);
        return null;
    }
}
