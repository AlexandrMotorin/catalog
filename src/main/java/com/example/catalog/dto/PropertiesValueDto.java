package com.example.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesValueDto extends AbstractDto{

    private Long propId;
    private List<ValueDto> valueDtoList;
}
