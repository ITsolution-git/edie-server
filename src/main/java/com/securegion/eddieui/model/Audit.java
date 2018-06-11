package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Audit {
    private String id;

    private String type;

    private String workflowName;
    private String flowId;
    private String clonedFlowId;
    private String finishedFlowId;
    private int step;

    private String itemName;
    private int itemStep;

    private String description;
    private String sentence;
    private String condition;
    private String shape;
    private long dateCreated;

    private String customerId;

    private String component;
    private String action;
    private String data;
    private String channel;
    private String userConnectorId;
    private String message;
    private String messageUniqueId;
    private String extra1;

    private Object dataObj;
}