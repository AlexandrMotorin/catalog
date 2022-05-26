package com.example.catalog.mapper;

import com.example.catalog.dto.RubricDto;
import com.example.catalog.model.Rubric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RubricMapper implements Mapper<RubricDto, Rubric> {

    private final PropertyMapper mapper;

    @Override
    public RubricDto mapTo(Rubric rubric) {

        System.out.println();
        Optional<Rubric> parent = Optional.of(rubric.getParent());

        return RubricDto.builder()
                .name(rubric.getName())
                .description(rubric.getDescription())
                .parentId(
                    5L//todo
                )
                .build();
    }

    @Override
    public Rubric mapFrom(RubricDto rubricDto) {
        return Rubric.builder()
                .name(rubricDto.getName())
                .description(rubricDto.getDescription())
                .build();
    }
}
