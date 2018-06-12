package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Line {
    String from;
    String to;
    Integer fromPoint;
    Integer toPoint;
    String width;
    String color;
    String type;
}
