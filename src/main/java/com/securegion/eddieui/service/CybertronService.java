package com.securegion.eddieui.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class CybertronService {
    private RestTemplate restTemplate = new RestTemplate();

    public Object getArticles() {
        String url = "http://www.cyber-security.io/rcontent/search/findAllPublicArticles?type=rss&type=text&draw=1&page=0&size=5&sort=dateCreated,desc";
        return restTemplate.getForObject(url, Object.class);
    }
}
