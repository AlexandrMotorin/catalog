package com.example.catalog.mapper;

import com.example.catalog.dto.AbstractDto;
import com.example.catalog.model.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDto>
        implements Mapper<E,D>{

    @Autowired
    private ModelMapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> destinationClass) {
        this.entityClass = entityClass;
        this.dtoClass = destinationClass;
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                :mapper.map(dto, entityClass);
    }

    Converter<E,D> toDtoConverter(){
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificField(source, destination);
            return context.getDestination();
        };
    }

    Converter<D,E> toEntityConverter(){
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificField(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificField(D source, E destination) {

    }

    void mapSpecificField(E source, D destination) {

    }

}
