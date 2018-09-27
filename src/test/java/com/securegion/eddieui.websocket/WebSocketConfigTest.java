package com.securegion.eddieui.websocket;

import com.securegion.eddieui.model.Incident;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SERGE on 27/09/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("testing")
@WebAppConfiguration
public class WebSocketConfigTest {
    @Autowired WebSocketConfig webSocketConfig;

    @Test
    public void pushIncidentsTest() {
        Collection<Incident> incidents = Arrays.asList(Incident.builder().id("1").build());
        webSocketConfig.send("incidents", incidents);
    }
 }