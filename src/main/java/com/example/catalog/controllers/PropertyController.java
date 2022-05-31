package com.example.catalog.controllers;

import com.example.catalog.dto.PropertyDto;
import com.example.catalog.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    public PropertyDto saveProperty(@RequestBody PropertyDto dto){
        return propertyService.saveProperty(dto);
    }

    @GetMapping
    public List<PropertyDto> getAll(){
        return propertyService.findAll();
    }
}
