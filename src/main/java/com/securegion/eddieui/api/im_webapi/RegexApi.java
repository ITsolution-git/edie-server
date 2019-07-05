package com.securegion.eddieui.api.im_webapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.securegion.eddieui.model.Result;
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
    Result<String> testRegex(@RequestBody JsonNode body) {
        String regex = StringUtils.defaultString(body.path("regex").asText());
        String text = StringUtils.defaultString(body.path("text").asText());

        Matcher m = Pattern.compile(regex).matcher(text);

        Result<String> result = new Result<>();
        result.setSuccess(m.find());
        return result;
    }
}
