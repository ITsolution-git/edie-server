package com.securegion.eddieui.websocket;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * Created by SERGE on 20/03/2017.
 */
@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
@Controller
@Log4j2
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer implements WebSocketConfigurer {

    @Autowired SimpMessagingTemplate template;
    @Autowired MonitorUISocketHandler monitorUISocketHandler;
    @Autowired EventSocketHandler eventSocketHandler;

    private String[] allowedOrigins = new String[] {"http://localhost:3000", "https://eddie-avatar.securegion.com"};

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/frontendupdates").setAllowedOrigins(allowedOrigins);
    }

    public void send(String path , Object msg) {
        template.convertAndSend("/frontendupdates/"+path, msg);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(monitorUISocketHandler, "/monitorupdate").setAllowedOrigins(allowedOrigins);
        registry.addHandler(eventSocketHandler, "/eventupdate").setAllowedOrigins(allowedOrigins);
        log.info("Registered agent sockets");
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(1024 * 800);
        container.setMaxBinaryMessageBufferSize(1024 * 800);
        container.setMaxSessionIdleTimeout(30000L);
        return container;
    }

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
//        if (!refreshed && event.getMessage().getHeaders().get("simpDestination") != null &&
//                event.getMessage().getHeaders().get("simpDestination").equals("/frontendupdates/refreshpage")) {
//            send("refreshpage", new JSONObject().put("refresh","refresh").toString());
//            refreshed = true;
//            log.info("push_refresh_page_to_ui()");
//        }
    }
}