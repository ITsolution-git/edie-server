package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping("/getHostname") Object getHostname(
            String iporhost, String user, String password,
            boolean isWindows, String collectorId, boolean noCred) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("getHostname")
                .data(mapper.createObjectNode()
                        .put("iporhost", iporhost)
                        .put("user", user)
                        .put("password", password)
                        .put("isWindows", isWindows)
                        .put("collectorId", collectorId)
                        .put("noCred", noCred)
                ).build(), Object.class);
    }

    @GetMapping("/isAgentUp")
    Result<String> isAgentUp(String id) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("isAgentUp")
                .data(mapper.createObjectNode()
                        .put("id", id)
                ).build(), Result.class);
    }

    @GetMapping("/installAgent") Result<String> installAgent(String id, String collectorId) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("installAgent")
                .data(mapper.createObjectNode()
                        .put("id", id)
                        .put("collectorId", collectorId)
                ).build(), Result.class);
    }
}
