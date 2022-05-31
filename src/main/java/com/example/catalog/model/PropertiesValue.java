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
public class PropertiesValue extends AbstractEntity{

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Properties property;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Value value;

    @OneToMany(mappedBy = "propertiesValue")
    private List<ItemPropertiesValue> propertiesValueList = new ArrayList<>();


}
