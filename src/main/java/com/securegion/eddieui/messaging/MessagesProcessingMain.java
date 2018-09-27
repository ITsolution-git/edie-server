package com.securegion.eddieui.messaging;

import com.securegion.eddieui.messaging.commands.FunctionRouter;
import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Log4j2
@Service
public class MessagesProcessingMain {
    @Autowired FunctionRouter functionRouter;

    private Queue<Message> incomingMessagesQueue = new ConcurrentLinkedQueue<>();

    public void enqueue(List<Message> messages) {
        incomingMessagesQueue.addAll(messages);
    }

    public void releaseQueue() {
        while (!incomingMessagesQueue.isEmpty()) {
            Message m = incomingMessagesQueue.poll();
            String type = StringUtils.defaultString(m.getType());
            switch (type) {
                case "function": {
                    functionRouter.route(m);
                    break;
                }
            }
        }
    }
}
