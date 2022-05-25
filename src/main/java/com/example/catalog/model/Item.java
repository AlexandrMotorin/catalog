package com.example.catalog.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;

    private String description;

    private int price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Rubric rubric;

    @OneToMany(mappedBy = "item")
    private List<ItemPropertiesValue> propertiesValueList;
}

