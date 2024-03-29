package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.*;
import com.securegion.eddieui.util.PageRequestUtil;
import com.securegion.eddieui.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Log4j2
@RestController
public class FlowApi {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    FlowHook flowHook;

    @PostMapping("/addFlow")
    Flow addFlow(@RequestBody Flow flow) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("addflow")
                    .data(flow)
                    .build();
            Result<String> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return mapper.readValue(res.getObject(), Flow.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/updateFlow")
    Flow updateFlow(@RequestBody Flow flow) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("updateflow")
                    .data(flow)
                    .build();
            Result<String> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return mapper.readValue(res.getObject(), Flow.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/deleteFlow")
    Result<Object> deleteFlow(@RequestBody Flow flow) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("deleteflow")
                    .data(flow)
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res != null) return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return new Result<>();
    }

    @GetMapping("/getAllFlows")
    Flow[] getAllFlows() {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("getAll")
                    .build();
            Flow[] res = flowHook.sendMessageSync(msg, Flow[].class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getFlowsByDevice")
    Object getFlowsByDevice(String deviceId, HttpServletResponse httpRes) {
        Flow[] res = null;
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("getByDevice")
                    .data(mapper.createObjectNode().put("deviceId", deviceId))
                    .build();
            res = flowHook.sendMessageSync(msg, Flow[].class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return ResponseUtil.wrapResponse(res, httpRes);
    }

    @GetMapping("/getFlow")
    Flow getFlow(String id) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("get")
                    .data(mapper.createObjectNode()
                            .put("flowId", id))
                    .build();
            return flowHook.sendMessageSync(msg, Flow.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getFlowByName")
    Flow getFlowByName(String name) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("getByName")
                    .data(mapper.createObjectNode()
                            .put("name", name))
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return mapper.convertValue(res.getObject(), Flow.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getAllClonedFlows")
    Flow[] getAllClonedFlows() {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("getAllCloned")
                    .build();
            Flow[] res = flowHook.sendMessageSync(msg, Flow[].class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getAllFlowGroups")
    FlowGroup[] getAllFlowGroups() {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Group")
                    .method("getAll")
                    .build();
            FlowGroup[] res = flowHook.sendMessageSync(msg, FlowGroup[].class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/addFlowGroup")
    Object addFlowGroup(@RequestBody FlowGroup group) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Group")
                    .method("add")
                    .data(group)
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return res.getObject();
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/updateFlowGroup")
    Object updateFlowGroup(@RequestBody FlowGroup group) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Group")
                    .method("update")
                    .data(group)
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return res.getObject();
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/deleteFlowGroup")
    Result<Object> deleteFlowGroup(@RequestBody FlowGroup group) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Group")
                    .method("delete")
                    .data(group)
                    .build();
            Result<Object> res = flowHook.sendMessageSync(msg, Result.class);
            if (res != null) return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return new Result<>();
    }

    @PostMapping("/saveFlowSetting")
    public FlowSetting saveFlowSetting(@RequestBody FlowSetting entity) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("saveFlowSetting")
                    .data(entity)
                    .build();
            return flowHook.sendMessageSync(msg, FlowSetting.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getFlowSetting")
    public FlowSetting getFlowSetting(String customerId) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("getFlowSetting")
                    .data(mapper.createObjectNode().put("customerId", customerId))
                    .build();
            return flowHook.sendMessageSync(msg, FlowSetting.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/flow/search/findByUuidIn")
    public Object findByUuidIn(
            @RequestParam(name = "uuid", required = false) String[] uuids) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("findByUuidIn")
                    .data(new HashMap<String, Object>(){{
                        put("uuids", uuids == null ? Arrays.asList() : uuids);
                    }})
                    .build();
            return flowHook.sendMessageSync(msg, Object.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }


    @PostMapping("/resetCustomerFlow")
    Flow resetCustomerFlow(@RequestBody Flow flow) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Flow")
                    .subcategory("Manage")
                    .method("resetCustomerFlow")
                    .data(flow)
                    .build();
            Flow res = flowHook.sendMessageSync(msg, Flow.class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }
}
