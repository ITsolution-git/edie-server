package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Cheng on 11/26/16.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomImage {
    @Id
    private String id;
    private String fileName;
    private String mimeType;
    private String content;

    private Origin origin;
    private String uuid;

    private boolean deleted;
    private Date updated;
}
