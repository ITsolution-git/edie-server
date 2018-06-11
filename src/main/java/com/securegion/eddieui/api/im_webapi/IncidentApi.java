package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Severity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
