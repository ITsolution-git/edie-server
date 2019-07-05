package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Message {
    private String id;
    private String name;
    private String username;
    private String text;
    private String message;
    private String chatroom;
    private String channel;
    private String sid;
    private String type;
    private Message originalMessage;

    private String emailto;
    private String emailfrom;
    private String emailsubject;
    private String emailbody;
    private String emailId;
    private String customerid;

    private String connectorId;
    private String userConnectorId;
    private String uniqueId;

    private List<Device> devices;
    private List<Credential> credentials;

    private boolean isAnswer;
    private boolean external;
    private String functionCategory;
    private String subcategory;
    private String method;

    private String ip;
    private Long timestamp;
    private Object data;
    private Map<String, Object> params;
    private String monitorid;
    private String agentid;
    private List<String> deviceid;
    private String description;
    private List<String> tags;
    
    private Incident incident;
}
