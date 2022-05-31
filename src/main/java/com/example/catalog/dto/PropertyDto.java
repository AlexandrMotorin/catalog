package com.example.catalog.dto;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto extends AbstractDto {
    private String name;
    private String description;
    private String units;
}
