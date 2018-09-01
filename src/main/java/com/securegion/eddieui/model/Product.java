package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String version;

    private List<String> tags;
    private List<String> classifiers;
    private List<String> parsers;
    private List<String> workflows;
    private List<String> incidents;

    private List<ProductDetectedAction> detectedActions;

    private Status status;
}
