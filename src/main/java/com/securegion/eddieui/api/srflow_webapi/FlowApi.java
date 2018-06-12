package com.securegion.eddieui.api.srflow_webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
                    .method("getAll")
                    .build();
            Flow[] res = flowHook.sendMessageSync(msg, Flow[].class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/getFlow")
    Flow getFlow(String id) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
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
    FlowGroup addFlowGroup(@RequestBody FlowGroup group) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Group")
                    .method("add")
                    .data(group)
                    .build();
            Result<String> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return mapper.readValue(res.getObject(), FlowGroup.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/updateFlowGroup")
    FlowGroup updateFlowGroup(@RequestBody FlowGroup group) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Group")
                    .method("update")
                    .data(group)
                    .build();
            Result<String> res = flowHook.sendMessageSync(msg, Result.class);
            if (res.isSuccess()) return mapper.readValue(res.getObject(), FlowGroup.class);
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
                    .functionCategory("Internal")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
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
                    .functionCategory("Internal")
                    .subcategory("Flow")
                    .method("getFlowSetting")
                    .data(mapper.createObjectNode().put("customerId", customerId))
                    .build();
            return flowHook.sendMessageSync(msg, FlowSetting.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }
}
