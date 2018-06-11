package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by SERGE on 18/08/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device implements Serializable {
    @Id
    private String id;
    private String name;
    private String slug;
    private String templateName;
    private List<String> tags;
    private String image;
    private Status status;

    private String lanip;
    private String wanip;
    private String hostname;

    private String info;
    private String os;
    private String osver;
    private String osDetails;
    private DeviceAgent agent;
    private long lastSeen;

    private List<String> workflowids;
    private List<Monitor> monitors;
    private List<Credential> credentials;
    private boolean useIntegratedSecurity;

    private String agentType;
    private String collectorId;

    private Map<String, Object> params;

//    private String mapid;
    private List<String> mapids;
    private Float x;
    private Float y;
    private Float width;
    private Float height;
    private Float angle;
    private Float textX;
    private Float textY;
    private Float textWidth;
    private Float textSize;
    private String align;

    private Line line;

    private String groupid;

    private List<GaugeItem> gauges;
    private boolean gaugeLocked;

    private String customerId;
}

