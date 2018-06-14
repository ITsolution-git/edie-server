package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Severity;
import com.securegion.eddieui.util.PageRequestUtil;
import com.securegion.eddieui.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/incident")
@RestController
public class IncidentApi {
    @Autowired IMHook imHook;

    @GetMapping("/dashboardinfo") String dashboardinfo() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Incident")
                .method("dashboardinfo")
                .build(), String.class);
    }


    @GetMapping("/search/findBySeverity")
    Object findBySeverity(Severity[] severity, @PageableDefault Pageable pageable, HttpServletResponse res) {
        Map<String, Object> data = new HashMap<>();
        data.put("severity", severity);
        data.put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable));
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Incident")
                .method("findBySeverity")
                .data(data)
                .build(), Object.class), res);
    }

    @GetMapping("/search/findBy")
    Object findBy(String id,
                 String devicename,
                 String description,
                 String workflow,
                 String category,
                 Severity[] severity,
                 Boolean acknowledged,
                 Boolean fixed,
                 Long afterStartTimestamp,
                 Long beforeStartTimestamp,
                 @PageableDefault Pageable pageable) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("devicename", devicename);
        data.put("description", description);
        data.put("workflow", workflow);
        data.put("category", category);
        data.put("acknowledged", acknowledged);
        data.put("fixed", fixed);
        data.put("afterStartTimestamp", afterStartTimestamp);
        data.put("beforeStartTimestamp", beforeStartTimestamp);
        data.put("severity", severity);
        data.put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable));

        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Incident")
                .method("findBy")
                .data(data)
                .build(), Object.class);
    }
}
