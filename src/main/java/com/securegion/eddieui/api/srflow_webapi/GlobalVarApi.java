package com.securegion.eddieui.api.srflow_webapi;

import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.FlowHook;
import com.securegion.eddieui.model.GlobalVar;
import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class GlobalVarApi {
    @Autowired FlowHook flowHook;

    @GetMapping("/getAllGlobalVars")
    GlobalVar[] getAllGlobalVars() {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("GlobalVar")
                    .method("getAll")
                    .build();
            GlobalVar[] res = flowHook.sendMessageSync(msg, GlobalVar[].class);
            return res;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }
}
