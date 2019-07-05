package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by master on 15/09/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Map {
    @Id
    private String id;
    private String name;
    private String description;
    private String mapgroup;
    private Boolean isdashboard;
    private String bgimg;
    private List<String> users;
}
