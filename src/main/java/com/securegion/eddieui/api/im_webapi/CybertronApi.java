package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.service.CybertronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cybertron")
public class CybertronApi {
    @Autowired
    CybertronService cybertronService;

    @GetMapping("/findArticles") Object findArticles(){
        return cybertronService.getArticles();
    }
}
