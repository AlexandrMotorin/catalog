package com.example.catalog.dto;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RubricDto extends AbstractDto {
    private String name;
    private Long parentId;
}
