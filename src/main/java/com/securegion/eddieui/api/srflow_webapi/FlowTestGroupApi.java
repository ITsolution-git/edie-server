package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.FlowTestGroup;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
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
@RequestMapping("/flowtestgroup")
public class FlowTestGroupApi {
    @Autowired FlowHook flowHook;
    @Autowired ObjectMapper mapper;

    @GetMapping
    Object getAll(HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .functionCategory("Flow")
                .subcategory("TestGroup")
                .method("getAll")
                .build(), Object.class), res);
    }

    @GetMapping("/{id}")
    Object getById(@PathVariable("id") String id, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .functionCategory("Flow")
                .subcategory("TestGroup")
                .method("getById")
                .data(mapper.createObjectNode().put("id", id))
                .build(), Object.class), res);
    }

    @PostMapping
    Object add(@RequestBody JsonNode entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .functionCategory("Flow")
                .subcategory("TestGroup")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @PutMapping("/{id}")
    Object save(@RequestBody JsonNode entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .functionCategory("Flow")
                .subcategory("TestGroup")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @DeleteMapping("/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return flowHook.sendMessageSync(Message.builder()
                .functionCategory("Flow")
                .subcategory("TestGroup")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
