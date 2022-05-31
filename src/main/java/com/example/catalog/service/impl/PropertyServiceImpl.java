package com.example.catalog.service.impl;

import com.example.catalog.dao.PropertyRepo;
import com.example.catalog.dto.PropertyDto;
import com.example.catalog.mapper.PropertyMapper;
import com.example.catalog.model.Properties;
import com.example.catalog.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;
    private final PropertyMapper mapper;

    @Override
    @Transactional
    public PropertyDto saveProperty(PropertyDto dto) {
        Properties result = propertyRepo.save(mapper.toEntity(dto));
        return mapper.toDto(result);
    }

    @Override
    public List<PropertyDto> findAll() {
        return propertyRepo
                .findAll().stream()
                .map(mapper::toDto)
                .collect(toList());
    }


}
