package com.example.catalog.service;

import com.example.catalog.dto.RubricDto;

public interface RubricService {
    void saveRubric(RubricDto rubricDto);
    RubricDto findRubricById(Long id);
}
