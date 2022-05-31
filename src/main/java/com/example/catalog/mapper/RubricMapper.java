package com.example.catalog.mapper;

import com.example.catalog.dao.RubricRepo;
import com.example.catalog.dto.RubricDto;
import com.example.catalog.model.Rubric;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class RubricMapper extends AbstractMapper<Rubric, RubricDto>{

    private final ModelMapper mapper;
    private final RubricRepo rubricRepo;

    @Autowired
    public RubricMapper(ModelMapper mapper, RubricRepo rubricRepo) {
        super(Rubric.class, RubricDto.class);
        this.mapper = mapper;
        this.rubricRepo = rubricRepo;
    }

    @PostConstruct
    private void setupMapper(){
        mapper.createTypeMap(RubricDto.class, Rubric.class)
                .addMappings(m -> m.skip(Rubric::setParent)).setPostConverter(toEntityConverter());
        mapper.createTypeMap(Rubric.class, RubricDto.class)
                .addMappings(m -> m.skip(RubricDto::setParentId)).setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificField(RubricDto source, Rubric destination) {
        if(!Objects.isNull(source.getParentId())) {
            Rubric parent = rubricRepo.getReferenceById(source.getParentId());
            destination.setParent(parent);
        }
    }

    @Override
    void mapSpecificField(Rubric source, RubricDto destination) {
        destination.setParentId(getId(source));
    }

    private Long getId(Rubric source){
        return Objects.isNull(source) || Objects.isNull(source.getParent())
                ? null
                : source.getParent().getId();
    }
}
