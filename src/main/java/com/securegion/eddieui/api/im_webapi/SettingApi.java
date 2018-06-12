package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Event;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Settings;
import com.securegion.eddieui.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j2
@RequestMapping("/setting")
@RestController
public class SettingApi {
    @Autowired IMHook imHook;

    @PostMapping
    Settings save(@RequestBody Settings entity, HttpServletResponse res) {
        Settings saved = null;
        try {
            saved = imHook.sendMessageSync(Message.builder()
                    .functionCategory("Internal")
                    .subcategory("Setting")
                    .method("save")
                    .build(), Settings.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return ResponseUtil.wrapResponse(saved, res);
    }

    @GetMapping("/search/envvars")
    List<Settings> findByEnvvarsIsNotNull() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
                .method("getAll")
                .build(), List.class);
    }

    @GetMapping("/search/identities")
    List<Settings> findByIdentitiesIsNotNull() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("Setting")
                .method("getByIdentities")
                .build(), List.class);
    }
}
