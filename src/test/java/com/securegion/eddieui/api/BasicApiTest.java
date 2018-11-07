package com.securegion.eddieui.api;

import com.securegion.eddieui.Const;
import com.securegion.eddieui.model.Incident;
import com.securegion.eddieui.model.Message;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by SERGE on 07/11/2018.
 */
public class BasicApiTest {

    @Test public void onMessageTest() {
        Map<String, Object> data = new HashMap<>();
        data.put("incidents", asList(Incident.builder().id("1").build(), Incident.builder().id("1").build()));

        List<Message> msgs = asList(Message.builder()
                .type(Const.MSG_TYPE_FUNC)
                .functionCategory("socket")
                .subcategory("UISocket")
                .method("pushIncidents")
                .data(data)
                .build());
        new RestTemplate().postForObject("http://127.0.0.1:8080/onMessage", msgs, String.class);
    }
}