package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Device;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import com.securegion.eddieui.util.PageRequestUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeviceApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping("/device")
    Object getAll(@PageableDefault Pageable pageable) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("getAll")
                .data(mapper.createObjectNode().put("page", PageRequestUtil.serialize((PageRequest)pageable)))
                .build(), Object.class);
    }

    @PostMapping("/device")
    @PutMapping("/device/{id}")
    Object save(@RequestBody Device entity) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("save")
                .data(entity)
                .build(), Object.class);
    }

    @DeleteMapping("/device/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Device")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }

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
