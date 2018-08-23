package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

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

    private Map<ItemType, String> item;
    private enum ItemType {DEVICE, MONITOR, PRODUCT}

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

    private Line line;

    private String groupid;
}
