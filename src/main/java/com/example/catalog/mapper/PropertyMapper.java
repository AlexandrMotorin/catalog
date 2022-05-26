package com.example.catalog.mapper;

import com.example.catalog.dto.PropertyDto;
import com.example.catalog.model.Properties;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper implements Mapper<PropertyDto, Properties>{

    @Override
    public PropertyDto mapTo(Properties property) {
        return null;
    }

    @Override
    public Properties mapFrom(PropertyDto dto) {
        return Properties.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .units(dto.getUnits())
                .build();
    }
}
