package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by SERGE on 22/11/2016.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential {
    private String id;
    private String name;
    private String description;
    private String username;
    private String password;
    private String type;
    private boolean isDefault;
    private boolean global;
    private List<String> deviceIds;
}
