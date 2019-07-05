package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserConnector {
    public enum ConnectorType{RocketChat, Slack, Mail, Rest, Gitlab, Jenkins}
    public enum MailType{SMTP, Gmail, Exchange}
    private String id;
    private String userId;
    private ConnectorType type;
    private String name;
    private String description;
    private String token;
    private String accessToken;
    private String url;
    private String userName;
    private String password;
    private MailType mailType;
    private String host;
    private String port;
    private List<Mapping> jsonMapping;
    private String json;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Mapping {
        String field;
        String varName;
        String tag;
    }
}
