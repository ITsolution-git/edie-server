package com.securegion.eddieui.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicApi {
    @GetMapping("/version") String version() {
        return "1.1";
    }
}
