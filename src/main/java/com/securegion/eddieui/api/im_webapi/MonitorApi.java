package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/monitor")
@RestController
public class MonitorApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping("/addBasicMonitor")
    Object addBasicMonitor(String id, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Monitor")
                .subcategory("Monitors")
                .method("addBasicMonitor")
                .data(mapper.createObjectNode().put("id", id))
                .build(), Object.class), res);
    }

    @GetMapping("/removeBasicMonitor")
    Object deleteBasicMonitor(String id, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Monitor")
                .subcategory("Monitors")
                .method("removeBasicMonitor")
                .data(mapper.createObjectNode().put("id", id))
                .build(), Object.class), res);
    }

    @GetMapping("/search/findByIds")
    Object findByIds(@RequestParam("ids") List<String> ids) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("ids", ids);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Monitor")
                .subcategory("Monitors")
                .method("findByIdIn")
                .data(data)
                .build(), Object.class);
    }
}
