package com.example.catalog.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Properties extends AbstractEntity{

    private String name;

    private String description;

    private String units;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "property", orphanRemoval = true)
    private List<PropertiesValue> propertiesValues = new ArrayList<>();

}
