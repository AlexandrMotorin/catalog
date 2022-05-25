package com.example.catalog.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rubric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;

    private String description;

    @ManyToOne
    private Rubric parent;

    @Builder.Default
    @OneToMany(mappedBy = "parent")
    @ToString.Exclude
    private List<Rubric> childRubrics = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "rubric")
    @ToString.Exclude
    private List<Item> itemList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "rubric")
    @ToString.Exclude
    private List<RubricProperties> rubricProperties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rubric rubric = (Rubric) o;
        return id != null && Objects.equals(id, rubric.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
