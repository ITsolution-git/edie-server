package com.securegion.eddieui.hook;

import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Log4j2
@Service
public class FlowHook {
    @Value("${flow.url.sendmsgsync}") String FLOW_SEND_MSG_SYNC;
    @Value("${flow.url.sendmsg}") String FLOW_SEND_MSG;

    private RestTemplate restTemplate = new RestTemplate();

    public boolean sendMessage(Message msg) {
        try {
            restTemplate.postForObject(FLOW_SEND_MSG, Arrays.asList(msg), Object.class);
            return true;
        } catch (Exception e) {
            log.error("Error", e);
        }
        return false;
    }

    public <T> T sendMessageSync(Message msg, Class<T> responseType) {
        try {
            return restTemplate.postForObject(FLOW_SEND_MSG_SYNC, msg, responseType);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }
}
