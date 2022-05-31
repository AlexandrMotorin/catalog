package com.example.catalog.service;

import com.example.catalog.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto saveProperty(PropertyDto dto);
    List<PropertyDto> findAll();
}
