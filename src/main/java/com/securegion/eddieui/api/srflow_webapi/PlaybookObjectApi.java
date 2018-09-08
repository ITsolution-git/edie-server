package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/playbookobject")
public class PlaybookObjectApi {
    @Autowired FlowHook flowHook;

    @GetMapping
    Object getAll(HttpServletResponse res) {
        Object data = null;
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("PlaybookObject")
                    .method("getAll")
                    .build();
            data = flowHook.sendMessageSync(msg, Object.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return ResponseUtil.wrapResponse(data, res);
    }

    @PostMapping
    Object add(@RequestBody JsonNode entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .type(Const.MSG_TYPE_FUNC)
                .functionCategory("Flow")
                .subcategory("PlaybookObject")
                .method("add")
                .data(entity)
                .build(), Object.class), res);
    }

    @PutMapping("/{id}")
    Object save(@RequestBody JsonNode entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(flowHook.sendMessageSync(Message.builder()
                .type(Const.MSG_TYPE_FUNC)
                .functionCategory("Flow")
                .subcategory("PlaybookObject")
                .method("update")
                .data(entity)
                .build(), Object.class), res);
    }

    @DeleteMapping("/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return flowHook.sendMessageSync(Message.builder()
                .type(Const.MSG_TYPE_FUNC)
                .functionCategory("Flow")
                .subcategory("PlaybookObject")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }
}
