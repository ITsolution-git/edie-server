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
public class Product {
    private String id;
    private String name;
    private String description;
    private String version;

    private List<String> tags;
    private List<String> classifiers;
    private List<String> parsers;
    private List<String> workflows;
    private List<String> incidents;
}
