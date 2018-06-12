package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Cheng on 4/28/17.
 */
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearch {
    @Id
    private String id;
    private String name;
    private String description;
    private String data;

    private Origin origin;
    private String uuid;

    private boolean deleted;
    private Date updated;
}
