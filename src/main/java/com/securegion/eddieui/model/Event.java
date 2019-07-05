package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Created by SERGE on 06/10/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Document(indexName = "#{@elastic_db}", type = "event")
public class Event {
    private String id;
    private List<String> tags;
    private String incidentid;
    private String monitorid;
    private List<String> deviceid;
    private List<String> workflowids;
    private Map<String,Object> params;
    private Long timestamp;
    private String ip;
    private String host;
    private String agentid;
    private String rawdata;
    private String monitortype;
    private Object dataobj;
    private String category;
    private Severity severity;
    private String description;
    private CheckResult lastResult;
    private String lastResultData;
    private long sequencer;

    private String name;
    private String username;
    private String text;
    private String message;
    private String chatroom;
    private String channel;
    private String sid;

    private String emailto;
    private String emailfrom;
    private String emailsubject;
    private String emailbody;
    private String emailId;
    private String customerid;

    private String connectorId;
    private String userConnectorId;
    private String uniqueId;

    private boolean external;
    private String function;
    private String method;
}
