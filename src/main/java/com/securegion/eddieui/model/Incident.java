package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by SERGE on 06/10/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {
    private String id;
    private String name;
    private String devicename;
    private List<String> deviceid;
    private String agentid;
    private String monitorid;
    private String monitorName;
    private String monitorgroupid;
    private List<Event> events;
    private List<Incident> incidents;
    private String description;
    private String workflow;
    private String category;
    private Severity severity;
    private List<IncidentComment> comments;
//    @Field(type = Date)
    private long startTimestamp;
//    @Field(type = Date)
    private Long endTimestamp;
    private List<String> assignedUsers;
//    @Field(type = Boolean)
    private boolean acknowledged;
//    @Field(type = Boolean)
    private boolean fixed;
    private String fixedUsername;
//    @Field(type = Date)
    private Long fixedTime;
    private List<String> actions;

    private Message message;
}

