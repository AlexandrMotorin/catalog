package com.example.catalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RubricPropertyDto {
    @JsonProperty("list")
    private List<Long> propsId;
}
