package com.example.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto extends AbstractDto{

    private String name;
    private String description;
    private String price;
    private Long RubricId;
    private PropertiesValueDto propertiesValueDto;
}
