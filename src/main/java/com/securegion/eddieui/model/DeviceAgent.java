package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Cheng on 7/7/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceAgent {
    private String version;

    private String host;
    private String ipaddress;

    private long lastSeen;
}
