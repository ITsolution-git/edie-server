package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.EddieHook;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.Incident;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import com.securegion.eddieui.model.Severity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Log4j2
@RestController
public class FlowSimulateApi {
    @Autowired ObjectMapper mapper;
    @Autowired FlowHook flowHook;

    @PostMapping("/simulateConnector")
    public Object simulateConnector(@RequestBody List<Map<String, Object>> m) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Simulate")
                    .method("simulate")
                    .data(new HashMap<String, Object>(){{
                        put("messages", m);
                    }})
                    .build();
            Result<Object> out = flowHook.sendMessageSync(msg, Result.class);
            return out;
        } catch (Exception e){
            log.error("Error", e);
        }
        return new Result<Object>();
    }
}
