package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Event;
import com.securegion.eddieui.model.Settings;
import com.securegion.eddieui.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequestMapping("/setting")
@RestController
public class SettingApi {
    @Autowired IMHook imHook;

    @PostMapping
    Settings save(@RequestBody Settings entity, HttpServletResponse res) {
        Settings saved = null;
        try {

        } catch (Exception e) {
            log.error("Error", e);
        }
        return ResponseUtil.wrapResponse(saved, res);
    }
}
