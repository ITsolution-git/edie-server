package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
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
        data.put("userId", userId);
        data.put("roleIds", roleIds);
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("User")
                .method("updateRoles")
                .data(data)
                .build(), Result.class);
    }

    @GetMapping("/updatePermissions")
    Result<String> updatePermissions(String userId, List<String> permissionIds) {
        Map<String, Object> data = new HashMap<>();
        data.put("userId", userId);
        data.put("permissionIds", permissionIds);
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("User")
                .method("updatePermissions")
                .data(data)
                .build(), Result.class);
    }

    @GetMapping("/findAllPermissions")
    List<Permission> findAllPermissions() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Internal")
                .subcategory("User")
                .method("findAllPermissions")
                .build(), List.class);
    }
}
