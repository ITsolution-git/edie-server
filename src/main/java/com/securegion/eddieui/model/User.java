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
public class User {
    private String id;

    private String username;
    private String hashedPassword;
    private String fullName;
    private String phone;
    private String country;
    private String customerId;

    private List<Permission> permissions;
    private List<Role> roles;

    private String searchOptions;
}
