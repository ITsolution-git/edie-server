package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by SERGE on 16/08/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericQuery {
    private String q;
    private List<String> qs;
    private String[] types;
    private String from;
    private String to;
    private Integer page;
    private Integer size;
    private String sortBy;
    private String sortDir;

    private int splitBy;
    private String splitUnit;
}
