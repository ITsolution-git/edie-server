package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Event;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.util.PageRequestUtil;
import com.securegion.eddieui.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/event")
@RestController
public class EventApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping("/search/findByDate")
    Object findByDate(String monitorId, long dateFrom, long dateTo,
                           @PageableDefault Pageable pageable,
                           HttpServletResponse res) {
        Map<String, Object> data = new HashMap<>();
        data.put("monitorId", monitorId);
        data.put("dateFrom", dateFrom);
        data.put("dateTo", dateTo);
        data.put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable));
        Object events = imHook.sendMessageSync(Message.builder()
                .functionCategory("Incident")
                .subcategory("Event")
                .method("findByDate")
                .data(data)
                .build(), Object.class);
        return ResponseUtil.wrapResponse(events, res);
    }

    @GetMapping("/search/findByUserConnector")
    Object findByUserConnectorId(
            String userConnectorId, long dateFrom, long dateTo,
            @PageableDefault Pageable pageable) {
        Map<String, Object> data = new HashMap<>();
        data.put("userConnectorId", userConnectorId);
        data.put("dateFrom", dateFrom);
        data.put("dateTo", dateTo);
        data.put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable));

        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Incident")
                .subcategory("Event")
                .method("findByUserConnectorId")
                .data(data)
                .build(), Object.class);
    }
}
