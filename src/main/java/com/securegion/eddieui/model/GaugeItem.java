package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GaugeItem {
    @Id
    private String id;
    private String name;
    private int widgetSize;
    private String gaugeSize;

    private String templateName;

    private int duration;
    private String durationUnit;
    private int splitBy;
    private String splitUnit;
    private int checkDuration;
    private String checkDurationUnit;

    private String resource;

    private String savedSearchId;
    private List<Map<String, Object>> savedSearchItems;
    private String monitorId;
    private String workflowId;
    private List<String> workflowIds;
    private String deviceId;
    private String serviceName;
    private List<String> monitorIds;
    private List<String> serviceNames;
    private String monitorGroupId;
    private List<Object> servers;
    private List<Object> logicalGroups;
    private List<String> searchIds;
    private String userConnectorId;

    private String timing;
    private String gaugeType;
    private int checkInterval;

    private List<String> severities;
    private String fixed;
    private long dateFrom;
    private long dateTo;

    private boolean forward;
    private String forwardBoardId;

    private Object layout;
    private String itemSize;
    private boolean showDeviceType;

    private boolean showImage;

    private String tableViewMode;

    private Object originalSize;
    private boolean minimized;
}
