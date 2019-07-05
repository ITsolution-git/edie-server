package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by SERGE on 15/12/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    @Id
    private String id;
    private String name;
    private String slug;
    private String templateName;
    private String image;
    private Status status;

    private String info;

    private String mapid;
    private Float x;
    private Float y;
    private Float width;
    private Float height;
    private Float angle;
    private Float textX;
    private Float textY;
    private Float textWidth;
    private Float textSize;
    private String align;

    private List<GaugeItem> gauges;
}
