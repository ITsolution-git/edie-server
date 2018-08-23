package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowItem {
    public enum ContentType {SIMPLE, VARIABLE, COMBINED}
    private String uuid;

    private int step;
    private String name;
    private String type;
    private String desc;

    private String sentence;
    private String condition;
    private ContentType contentType;
    private String variable;
    private String response;
    private String function;
    private String varUuid;

    private String fieldType;
    private String field;
    private String varField;
    private boolean gotoFirstStep;
    private String gotoIfFalse;

    private Map<String, String> mapping;
    private List<ConditionWithValues> matches;
    private List<Map<String, String>> params;
    private List<Map<String, String>> resVars;
    private List<Map<String, String>> queryItems;
    private boolean saveMsg;

    private String executorId;
    private String serviceName;
    private String ip;

    private String receiver;
    private String title;
    private String body;

    private String channel;
    private String room;

    private Map<String, Object> uiprops;
    private Map<String, Object> grokFieldValues;
    private List<String> visibleGrokFields;

    private List<FlowItem> flowItemDetails;
}