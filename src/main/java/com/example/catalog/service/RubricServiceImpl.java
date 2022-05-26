package com.example.catalog.service;

import com.example.catalog.dao.PropertyRepo;
import com.example.catalog.dao.RubricRepo;
import com.example.catalog.dto.RubricDto;
import com.example.catalog.mapper.Mapper;
import com.example.catalog.mapper.RubricMapper;
import com.example.catalog.model.Rubric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RubricServiceImpl implements RubricService {

    private final RubricRepo rubricRepo;
    private final PropertyRepo propertyRepo;
    private final RubricMapper mapper;

    @Override
    @Transactional
    public void saveRubric(RubricDto rubricDto) {
        var rubric = mapper.mapFrom(rubricDto);
        var parentId = rubricDto.getParentId();

        if (rubricDto.getParentId() != null) {
            var id = rubricRepo.getReferenceById(parentId);
            rubric.setParent(id);
        }

        rubricRepo.save(rubric);
    }

    @Override
    public RubricDto findRubricById(Long id) {
        Optional<Rubric> rubric = rubricRepo.findById(id);

        RubricDto dto = null;
        if(rubric.isPresent()) {
            dto = mapper.mapTo(rubric.get());
        }

        return dto;
    }
}
