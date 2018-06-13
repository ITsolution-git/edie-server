package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Event;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Settings;
import com.securegion.eddieui.util.PageRequestUtil;
import com.securegion.eddieui.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequestMapping("/setting")
@RestController
public class SettingApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping
    Object getAll(@PageableDefault Pageable pageable) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
                .method("getAll")
                .data(mapper.createObjectNode().put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable)))
                .build(), Object.class);
    }

    @PostMapping
    @PutMapping("/{id}")
    Object save(@RequestBody JsonNode entity) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
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
                .subcategory("Setting")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/search/envvars")
    List<Settings> findByEnvvarsIsNotNull() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
                .method("envvars")
                .build(), List.class);
    }

    @GetMapping("/search/identities")
    List<Settings> findByIdentitiesIsNotNull() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
                .method("getByIdentities")
                .build(), List.class);
    }
}
