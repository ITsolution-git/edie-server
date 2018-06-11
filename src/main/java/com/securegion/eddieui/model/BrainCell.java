package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BrainCell {
    private String id;
    private String name;
    private String description;
    private String type;
    private String key;
    private Object value;
    private ValueType valueType;
    private String uuid;
    private String functionCategory;
    private String functionSubcategory;
    private String functionMethod;
    private boolean external;
    private String runOn;

    private boolean blockIP;
    private String severity;

    private List<String> params;
    private Map<String, Object> params2;

    public enum ValueType {
        WORKFLOW, TEXTRESPONSE, FUNCTION, TEXT, COMMAND, IM, SHELL
    }
}
