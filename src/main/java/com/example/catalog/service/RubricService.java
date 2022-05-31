package com.example.catalog.service;

import com.example.catalog.dto.RubricDto;

import java.util.List;

public interface RubricService {
    RubricDto saveRubric(RubricDto rubricDto);
    RubricDto findRubricById(Long id);
    void addProperty(Long id, List<Long> propsId);
}
