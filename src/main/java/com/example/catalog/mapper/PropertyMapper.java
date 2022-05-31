package com.example.catalog.mapper;

import com.example.catalog.dto.PropertyDto;
import com.example.catalog.model.Properties;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper extends AbstractMapper<Properties, PropertyDto>{
    public PropertyMapper() {
        super(Properties.class,PropertyDto.class);
    }
}
