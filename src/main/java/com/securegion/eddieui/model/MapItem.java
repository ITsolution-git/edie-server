package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by SERGE on 21/08/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapItem {
    @Id
    private String id;

    private enum ItemType {DEVICE, MONITOR, PRODUCT, LINE, LONGHUB}
    private ItemType type;
    private String itemId;
    private String parentName;

    private String groupid;

    private List<String> mapids;
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

    private String from;
    private String to;
    private Integer fromPoint;
    private Integer toPoint;
    private String lineWidth;
    private String color;
    private String lineType;
}
