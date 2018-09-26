package com.securegion.eddieui.api;

import com.securegion.eddieui.messaging.MessagesProcessingMain;
import com.securegion.eddieui.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicApi {
    @Autowired MessagesProcessingMain messagesProcessingMain;
    @GetMapping("/version") String version() {
        return "1.4";
    }

    @PostMapping("/onMessage")
    public void onMessage(@RequestBody List<Message> messages) {
        messagesProcessingMain.enqueue(messages);
    }
}
