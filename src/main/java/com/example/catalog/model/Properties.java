package com.example.catalog.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(exclude = {
        "rubricPropsList",
        "propertiesValues"
})
@ToString(exclude = {
        "rubricPropsList",
        "propertiesValues"
})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;

    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "property")
    private List<RubricProperties> rubricPropsList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "property")
    private List<PropertiesValue> propertiesValues = new ArrayList<>();
}
