package com.securegion.eddieui.api;

import com.securegion.eddieui.hook.AAAHook;
import com.securegion.eddieui.model.Audit;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Log4j
@RestController
public class AuditApi {
    @Autowired
    AAAHook aaaHook;

    @GetMapping("/getFinishedFlowAudit")
    public List<Audit> findGroupedByFlow(boolean lastOnly, String messageUniqueId) {
        return aaaHook.findGroupedByFlow(lastOnly, messageUniqueId);
    }

    @GetMapping("/audit/findByCloned")
    public Object findByCloned(String id) {
        return aaaHook.findByCloned(id);
    }

    @GetMapping("/audit/findByDate")
    public Object findByDate(@RequestParam Map<String,String> params) {
        return aaaHook.findByDate(params);
    }
}
