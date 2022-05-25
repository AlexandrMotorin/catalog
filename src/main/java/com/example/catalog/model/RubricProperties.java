package com.example.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RubricProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Properties property;

    @ManyToOne
    private Rubric rubric;

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
        rubric.getRubricProperties().add(this);
    }

    public void setProperties(Properties property) {
        this.property = property;
        property.getRubricPropsList().add(this);
    }
}
