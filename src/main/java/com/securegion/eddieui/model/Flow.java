package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flow {
    @Id
    private String id;
    private String name;
    private String description;
    private List<FlowItem> flowItems;
    private String uuid;
    private String type;

    private String ownerUser;
    private List<String> permitterUsers;

    private String groupId;

    private int currentItemStep;
    private int currentItemDetailStep;
    private Map<String, String> responseVars;

    private int interval;
    private String intervalUnit;

    private String userConnectorId;
    private String messageUniqueId;

    private Map<String, String> mapping;

    private boolean calledDirect;
    private boolean scheduled;
    private boolean paused;
    private boolean sendBack;

    private boolean timeRange;
    private int startHour;
    private int endHour;

    private boolean openIncident;
    private boolean sendChat;
    private String chatChannel;

    private boolean useCorrelation;
    private List<String> correlations;
    private List<String> tags;
    private boolean runByDevice;

    private List<Incident> incidents;

    private String incidentTemplateId;

    private boolean applyAllDevices;
    private List<String> applyDeviceIds;

    private ProductFilterType filterType;
    private String productTypeId;
    private String productId;

    private long updated;

    public enum ProductFilterType {
        PRODUCT, PRODUCT_TYPE
    }
}
