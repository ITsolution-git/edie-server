package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 15/09/16.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Monitor {
    public enum basicparamkeys{checkinterval,timeout,port,url}

    private String uid;
    private String name;
    private String monitortype;
    private List<String> tags;
    private boolean executable;
    private boolean enabled;
    private boolean basic;
    private List<String> workflowids;
    private Map<String,Object> params;
    private String action;
    private Status status;
    private Long lastrun;
    private Long lastsuccess;
    private Long lastfalure;
    private CheckResult checkResult;
    private String agentid;
    private String agentType;
    private String collectorId;
    private String credentialId;

    public void setStatusWithAutoTimestamp(Status status) {
        this.status = status;
        this.lastrun = System.currentTimeMillis();

        if (Status.UP.equals(status)) this.lastsuccess = System.currentTimeMillis();
        else if (Status.DOWN.equals(status)) this.lastfalure = System.currentTimeMillis();
        else if (Status.UNKNOWN.equals(status)) this.lastrun = 0L;
    }

    public enum MonitorType{SECURITY}
}
