package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/connector")
public class ConnectorApi {
    @Autowired FlowHook flowHook;
    @Autowired
    ObjectMapper mapper;

    @GetMapping("/getAll") Connector[] findAll(){
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Connector")
                    .method("getAll")
                    .build();
            Connector[] list = flowHook.sendMessageSync(msg, Connector[].class);
            log.info(list);
            return list;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/save")
    Connector saveConnector(@RequestBody Connector connector) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Connector")
                    .method("save")
                    .data(connector)
                    .build();
            return flowHook.sendMessageSync(msg, Connector.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/delete")
    Result<Object> deleteConnector(@RequestBody Connector connector) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Connector")
                    .method("delete")
                    .data(connector)
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res != null) return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return new Result<>();
    }
}
