package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GaugeBoard {
    @Id
    private String id;
    private String name;
    private String type;

    private List<GaugeItem> gauges;

    private long defaultSetDate;

    private Origin origin;
    private String uuid;

    private boolean deleted;
    private Date updated;
}
