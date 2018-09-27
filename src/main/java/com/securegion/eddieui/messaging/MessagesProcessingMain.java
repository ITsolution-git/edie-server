package com.securegion.eddieui.messaging;

import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Log4j2
@Service
public class MessagesProcessingMain {
    private Queue<Message> incomingMessagesQueue = new ConcurrentLinkedQueue<>();
    public void enqueue(List<Message> messages) {
        incomingMessagesQueue.addAll(messages);
    }

    public void releaseQueue() {

    }
}
