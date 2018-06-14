package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connector {
    public enum OSType{WINDOWS, LINUX}
    public enum Mode{COLLECTOR, AGENT}

    @Id
    private String id;
    private String name;
    private String desc;
    private String version;
    private Mode mode;

    private long lastSeen;
    private String host;
    private String ip;
    private Integer port;

    private OSType ostype;

    private List<String> relatedIPs;
    private List<Agent> agents;

    private ConnectorConfig config;
}
