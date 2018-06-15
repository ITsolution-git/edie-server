package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
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
import java.util.Map;

@RequestMapping("/map")
@RestController
public class MapApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping
    Object getAll(@PageableDefault Pageable pageable, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Dashboard")
                .subcategory("Map")
                .method("getAll")
                .data(mapper.createObjectNode().put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable)))
                .build(), Object.class), res);
    }

    @PostMapping
    Object add(@RequestBody Map entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Dashboard")
                .subcategory("Map")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @PutMapping("/{id}")
    Object save(@RequestBody Map entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Dashboard")
                .subcategory("Map")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @DeleteMapping("/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Dashboard")
                .subcategory("Map")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
