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
public class Rubric extends AbstractEntity{

    private String name;

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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "rubric_properties")
    private List<Properties> properties = new ArrayList<>();

    public void setParent(Rubric parent) {
        this.parent = parent;
        parent.getChildRubrics().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rubric rubric = (Rubric) o;
        return Objects.equals(name, rubric.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
