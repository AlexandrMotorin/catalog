package com.example.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PropertyDto implements Serializable {
    private String name;
    private String description;
    private String units;
}
