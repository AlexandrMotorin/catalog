package com.example.catalog.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertiesValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Properties property;

    @ManyToOne
    private Value value;

    @OneToMany(mappedBy = "propertiesValue")
    private List<ItemPropertiesValue> propertiesValueList = new ArrayList<>();

    public void setProperty(Properties property) {
        this.property = property;
        property.getPropertiesValues().add(this);
    }

    public void setValue(Value value) {
        this.value = value;

    }


}
