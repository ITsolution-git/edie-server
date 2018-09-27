package com.securegion.eddieui.schedule;

import com.securegion.eddieui.messaging.MessagesProcessingMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AllSchedule {
    @Autowired
    MessagesProcessingMain messageService;

    @Scheduled(fixedDelay = 300)
    private void releaseReceivedMessageQueue() {
        messageService.releaseQueue();
    }
}
