package com.securegion.eddieui.api;

import com.securegion.eddieui.Const;
import com.securegion.eddieui.conf.Config_Tests_Environment;
import com.securegion.eddieui.messaging.MessagesProcessingMain;
import com.securegion.eddieui.model.Incident;
import com.securegion.eddieui.model.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by SERGE on 07/11/2018.
 */
public class BasicApiTest extends Config_Tests_Environment {
    @Autowired MessagesProcessingMain messagesProcessingMain;

    @Test public void onMessageTest() {
        Map<String, Object> data = new HashMap<>();
        data.put("incidents", asList(Incident.builder().id("1").build(), Incident.builder().id("1").build()));

        messagesProcessingMain.enqueue(asList(Message.builder()
                .type(Const.MSG_TYPE_FUNC)
                .functionCategory("socket")
                .subcategory("UISocket")
                .method("pushIncidents")
                .data(data)
                .build()));

        messagesProcessingMain.releaseQueue();
    }
}