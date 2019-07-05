package com.securegion.eddieui.hook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Log4j2
@Service
public class EddieHook {

    @Value("${eddie.url.sendmsg}") String URL_SEND_MSG;
    @Value("${eddie.url.sendmsgsync}") String URL_SEND_MSG_SYNC;

    @Autowired
    ObjectMapper mapper;

    private RestTemplate restTemplate = new RestTemplate();
    private Queue<Message> queue = new ConcurrentLinkedQueue<>();

    public void sendMessage(Message msg) {
        msg.setChannel("IM");
        queue.add(msg);
        log.info("Eddie Message Queue: " + queue.size());
    }

    public <T> T sendMessageSync(Message msg, Class<T> responseType) {
        try {
            return restTemplate.postForObject(URL_SEND_MSG_SYNC, msg, responseType);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    public void sendReply(String text, Message original) {
        sendMessage(Message.builder()
                .isAnswer(true)
                .data(text)
                .originalMessage(original)
                .build());
    }

    public void releaseQueue() {
        try {
            if (queue.isEmpty()) return;

            List<Message> msgs = new ArrayList<>();
            while (!queue.isEmpty()) {
                msgs.add(queue.poll());
            }

            restTemplate.postForObject(URL_SEND_MSG, msgs, String.class);
            log.info("Sent Eddie Messages: " + msgs.size());
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}
