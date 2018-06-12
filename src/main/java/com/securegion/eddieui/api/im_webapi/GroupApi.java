package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Group;
import com.securegion.eddieui.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/group")
@RestController
public class GroupApi {
    @Autowired
    IMHook imHook;
    @Autowired
    ObjectMapper mapper;

    @GetMapping
    Object getAll(@PageableDefault Pageable pageable) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Group")
                .method("getAll")
                .data(pageable)
                .build(), Object.class);
    }

    @PostMapping
    @PutMapping("/{id}")
    Object save(@RequestBody Group entity) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Group")
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
                .subcategory("Group")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
