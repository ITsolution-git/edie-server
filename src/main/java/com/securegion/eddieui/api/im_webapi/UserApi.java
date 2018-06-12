package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import com.securegion.eddieui.model.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
public class UserApi {
    @Autowired IMHook imHook;

    @GetMapping("/findAllRoles")
    List<Role> findAllRoles() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("User")
                .method("findAllRoles")
                .build(), List.class);
    }

    @GetMapping("/updateRoles")
    Result<String> updateRoles(String userId, List<String> roleIds) {
        Map<String, Object> data = new HashMap<>();
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("User")
                .method("updateRoles")
                .data(data)
                .build(), Result.class);
    }
}
