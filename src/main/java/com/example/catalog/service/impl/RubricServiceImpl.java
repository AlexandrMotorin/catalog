package com.example.catalog.service.impl;

import com.example.catalog.dao.PropertyRepo;
import com.example.catalog.dao.RubricRepo;
import com.example.catalog.dto.RubricDto;
import com.example.catalog.mapper.RubricMapper;
import com.example.catalog.model.Properties;
import com.example.catalog.model.Rubric;
import com.example.catalog.service.RubricService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RubricServiceImpl implements RubricService {

    private final RubricRepo rubricRepo;
    private final PropertyRepo propertyRepo;
    private final RubricMapper rubricMapper;

    @Override
    @Transactional
    public RubricDto saveRubric(RubricDto rubricDto) {
        Rubric entity = rubricMapper.toEntity(rubricDto);
        return rubricMapper.toDto(rubricRepo.save(entity));
    }

    @Override
    public RubricDto findRubricById(Long id) {
        Rubric entity = rubricRepo.findById(id).orElse(null);
        return rubricMapper.toDto(entity);
    }

    @Override
    @Transactional
    public void addProperty(Long id, List<Long> propsId) {
        Rubric rubric = rubricRepo.findById(id).get();
        propsId.forEach(i -> {
            Properties prop = propertyRepo.findById(i).get();
            rubric.getProperties().add(prop);
        });
    }
}
