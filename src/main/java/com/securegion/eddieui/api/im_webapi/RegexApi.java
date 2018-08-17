package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
@RestController
public class RegexApi {
    @PostMapping("/testRegex")
    Object testRegex(@RequestBody JsonNode body) {
        String regex = StringUtils.defaultString(body.path("regex").asText());
        String text = StringUtils.defaultString(body.path("text").asText());

        Matcher m = Pattern.compile(regex).matcher(text);

        return null;
    }
}
