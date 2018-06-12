package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.util.PageRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/monitortemplate")
@RestController
public class MonitorTemplateApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping
    Object getAll(@PageableDefault PageRequest pageable) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("MonitorTemplate")
                .method("getAll")
                .data(mapper.createObjectNode().put("pageRequest", PageRequestUtil.serialize(pageable)))
                .build(), Object.class);
    }

    @PostMapping
    @PutMapping("/{id}")
    Object save(@RequestBody JsonNode entity) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("MonitorTemplate")
                .method("save")
                .data(entity)
                .build(), Object.class);
    }

    @DeleteMapping("/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("MonitorTemplate")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
