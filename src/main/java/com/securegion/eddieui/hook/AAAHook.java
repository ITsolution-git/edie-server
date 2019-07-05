package com.securegion.eddieui.hook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.model.Audit;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class AAAHook {

    @Value("${sra.url.base:}") String AAA_URL;
    @Value("${sra.url.audit.findbyflow}") String AAA_AUDIT_FINDBYFLOW_URL;
    @Value("${sra.url.audit.findbydate2}") String AAA_AUDIT_FINDBYDATE_URL;

    @Autowired
    ObjectMapper mapper;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Audit> findGroupedByFlow(boolean lastOnly, String messageUniqueId) {
        try {
            String url = AAA_URL + "/audit/getFinishedFlows?lastOnly=" + lastOnly +
                    "&messageUniqueId=" + StringUtils.defaultString(messageUniqueId);
            Audit[] items = restTemplate.getForObject(url,   Audit[].class);
            if (items != null) return Arrays.asList(items);
        } catch (Exception e) {
            log.error("Error", e);
        }

        return Arrays.asList();
    }

    public Object findByCloned(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(AAA_AUDIT_FINDBYFLOW_URL, Object.class, params);
    }

    public Object findByDate(Map<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AAA_AUDIT_FINDBYDATE_URL);
        for(String key : params.keySet()) {
            builder.queryParam(key, params.get(key));
        }
        String url = builder.build().toUri().toString();
        log.info(url);
        return restTemplate.getForObject(url, Object.class);
    }
}
