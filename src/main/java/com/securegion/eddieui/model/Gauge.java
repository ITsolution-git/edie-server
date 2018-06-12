package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gauge {
    @Id
    private String id;
    private String name;
    private String image;

    private int aspectWidth;
    private int aspectHeight;

    private int width;
    private int height;

    private Origin origin;
    private String uuid;

    private boolean deleted;
    private Date updated;
}
