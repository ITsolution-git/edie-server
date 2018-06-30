package com.securegion.eddieui.api.eddie_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.EddieHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.SimSample;
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
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/simsample")
public class SimSampleApi {
    @Autowired EddieHook eddieHook;
    @Autowired ObjectMapper mapper;

    @GetMapping
    Object getAll(@PageableDefault Pageable pageable, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(eddieHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Sample")
                .method("getAll")
                .data(mapper.createObjectNode().put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable)))
                .build(), Object.class), res);
    }

    @GetMapping("/{id}")
    Object getById(@PathVariable("id") String id, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(eddieHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Sample")
                .method("getById")
                .data(mapper.createObjectNode().put("id", id))
                .build(), Object.class), res);
    }

    @PostMapping
    Object add(@RequestBody SimSample entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(eddieHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Sample")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @PutMapping("/{id}")
    Object save(@RequestBody SimSample entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(eddieHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Sample")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @DeleteMapping("/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return eddieHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Sample")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
