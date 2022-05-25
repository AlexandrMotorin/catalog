package com.example.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemPropertiesValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PropertiesValue propertiesValue;

    @ManyToOne
    private Item item;

    public void setItem(Item item) {
        this.item = item;
        item.getPropertiesValueList().add(this);
    }

    public void setPropertiesValue(PropertiesValue propertiesValue) {
        this.propertiesValue = propertiesValue;
        propertiesValue.getPropertiesValueList().add(this);
    }
}
