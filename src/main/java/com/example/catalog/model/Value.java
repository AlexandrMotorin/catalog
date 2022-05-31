package com.example.catalog.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "values")
public class Value extends AbstractEntity{

    private String value;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "value")
    private List<PropertiesValue> propertiesValues = new ArrayList<>();
}
