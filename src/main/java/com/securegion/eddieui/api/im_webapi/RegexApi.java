package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class RegexApi {
    @PostMapping("/testRegex")
    void testRegex(@RequestBody JsonNode body) {
        String pattern = StringUtils.defaultString(body.path("pattern").asText());
        String text = StringUtils.defaultString(body.path("text").asText());



    }
}
