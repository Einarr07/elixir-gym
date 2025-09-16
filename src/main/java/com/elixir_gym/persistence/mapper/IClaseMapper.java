package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;
import com.elixir_gym.persistence.entity.ClaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClaseMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "nivel", target = "dificultad")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "capacidadMax", target = "capacidad_max")
    ClaseDto toDto(ClaseEntity clase);

    List<ClaseDto> toDtoList(Iterable<ClaseEntity> clase);

    @InheritInverseConfiguration
    ClaseEntity toEntity(ClaseDto claseDto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "dificultad", target = "nivel")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "capacidad_max", target = "capacidadMax")
    void updateClase(ActualizarClaseDto actualizarClaseDto, @MappingTarget ClaseEntity claseEntity);
}
