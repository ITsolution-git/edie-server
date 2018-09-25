package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Device;
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
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
public class DeviceApi {
    @Autowired IMHook imHook;
    @Autowired ObjectMapper mapper;

    @GetMapping("/device")
    Object getAll(@PageableDefault Pageable pageable, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("getAll")
                .data(mapper.createObjectNode().put("pageRequest", PageRequestUtil.serialize((PageRequest)pageable)))
                .build(), Object.class), res);
    }

    @GetMapping("/device/{id}")
    Object getById(@PathVariable("id") String id, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("getById")
                .data(mapper.createObjectNode().put("id", id))
                .build(), Object.class), res);
    }

    @PostMapping("/device")
    Object add(@RequestBody Device entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @PutMapping("/device/{id}")
    Object save(@RequestBody Device entity, HttpServletResponse res) {
        return ResponseUtil.wrapResponse(imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("save")
                .data(entity)
                .build(), Object.class), res);
    }

    @DeleteMapping("/device/{id}")
    Object delete(@PathVariable("id") String id) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("id", id);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("delete")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findLinesByMapids")
    Object findLinesByMapids(@RequestParam("mapids") List<String> mapids) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("mapids", mapids);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findLinesByMapids")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findDevicesByMapids")
    Object findDevicesByMapids(@RequestParam("mapids") List<String> mapids) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("mapids", mapids);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findDevicesByMapids")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findLinesByGroupid")
    Object findLinesByGroupid(String groupid) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("groupid", groupid);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findLinesByGroupid")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findDevicesByGroupid")
    Object findDevicesByGroupid(String groupid) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("groupid", groupid);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findDevicesByGroupid")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findAgents")
    Object findAgents(@PageableDefault Pageable pageable) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("pageRequest", PageRequestUtil.serialize(pageable));
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findAgents")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/searchByName")
    Object searchByName(String name, @PageableDefault Pageable pageable) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("name", name);
            put("pageRequest", PageRequestUtil.serialize(pageable));
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("searchByName")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findAllDevices")
    Object findAllDevices() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findAllDevices")
                .build(), Object.class);
    }

    @GetMapping("/device/search/findBySlug")
    Object findBySlug(String slug) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("slug", slug);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findBySlug")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findByMapids")
    Object findByMapids(@RequestParam("mapids") List<String> mapids) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("mapids", mapids);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findByMapids")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/device/search/findByTagsIn")
    Object findByTagsIn(@RequestParam("tag") List<String> tag) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("tag", tag);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findByTagsIn")
                .data(data)
                .build(), Object.class);
    }

    @GetMapping("/getHostname") Object getHostname(
            String iporhost, String user, String password,
            boolean isWindows, String collectorId, boolean noCred) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
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
                .functionCategory("Device")
                .subcategory("Device")
                .method("isAgentUp")
                .data(mapper.createObjectNode()
                        .put("id", id)
                ).build(), Result.class);
    }

    @GetMapping("/installAgent")
    Result<String> installAgent(String id, String collectorId) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("installAgent")
                .data(mapper.createObjectNode()
                        .put("id", id)
                        .put("collectorId", collectorId)
                ).build(), Result.class);
    }

    @GetMapping("/findAllApps")
    Object findAllApps(boolean hideDuplicate) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findAllApps")
                .data(mapper.createObjectNode()
                        .put("hideDuplicate", hideDuplicate)
                ).build(), Result.class);
    }

    @GetMapping("/device/search/findByIds")
    Object findByIds(@RequestParam("ids") List<String> ids) {
        Map<String, Object> data = new HashMap<String, Object>(){{
            put("ids", ids);
        }};
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Device")
                .subcategory("Device")
                .method("findByIdIn")
                .data(data)
                .build(), Object.class);
    }
}
