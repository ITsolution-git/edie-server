package com.securegion.eddieui.api.eddie_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.EddieHook;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.Incident;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Severity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Log4j2
@RestController
public class SimulateApi {
    @Autowired ObjectMapper mapper;
    @Autowired FlowHook flowHook;

    @PostMapping("/simulateConnector")
    public String simulateConnector(@RequestBody List<Message> m) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Simulate")
                    .method("simulate")
                    .data(m)
                    .build();
            String out = flowHook.sendMessageSync(msg, String.class);
            return out;
        } catch (Exception e){
            log.error("Error", e);
        }
        return "Failed";
    }
}
