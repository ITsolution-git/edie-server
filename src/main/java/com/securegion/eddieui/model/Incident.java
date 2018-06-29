package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

/**
 * Created by SERGE on 06/10/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {
    @Id
    private String id;
    private String name;
    private String devicename;
    private List<String> deviceid;
    private String agentid;
    private String monitorid;
    private String monitortype;
    private String monitorName;
    private String monitorgroupid;
    private List<Incident> incidents;
    private String description;
    private String workflow;
    private String category;
    private Severity severity;
    private List<IncidentComment> comments;
    private Map<String, Object> params;
    private long startTimestamp;
    private Long endTimestamp;
    private List<String> assignedUsers;
    private boolean acknowledged;
    private boolean fixed;
    private String fixedUsername;
    private Long fixedTime;
    private List<String> actions;
    private String customerId;
    private boolean correlant;
    private String createWfId;
    private String createdWfName;
    private Message message;
    private Object data;
    private boolean updateDevice;
    private String ip;
    private String text;
    private List<String> tags;
}

