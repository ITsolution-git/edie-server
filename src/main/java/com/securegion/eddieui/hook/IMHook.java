package com.securegion.eddieui.hook;

import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class IMHook {
    @Value("${im.url.sendmsgsync}") String URL_SEND_MSG_SYNC;
    private RestTemplate restTemplate = new RestTemplate();

    public <T> T sendMessageSync(Message msg, Class<T> responseType) {
        try {
            return restTemplate.postForObject(URL_SEND_MSG_SYNC, msg, responseType);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }
}
