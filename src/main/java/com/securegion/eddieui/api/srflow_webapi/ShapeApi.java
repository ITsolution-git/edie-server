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
import java.awt.*;

@Log4j2
@RestController
@RequestMapping("/shape")
public class ShapeApi {
    @Autowired FlowHook flowHook;

    @GetMapping("/getAll")
    Object getAllShapes(HttpServletResponse res) {
        Object data = null;
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Shape")
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
                .subcategory("Shape")
                .method("add")
                .data(entity)
                .build(), Object.class), res);
    }
}
