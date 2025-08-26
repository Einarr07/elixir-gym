package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEntrenamientoMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "nivel", target = "nivel")
    @Mapping(source = "duracionSemanas", target = "semanas_de_duracion")
    EntrenamientoDto toDto(EntrenamientoEntity entity);
    List<EntrenamientoDto> toDtoList(Iterable<EntrenamientoEntity> entity);

    @InheritInverseConfiguration
    EntrenamientoEntity toEntity(EntrenamientoDto dto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "nivel", target = "nivel")
    @Mapping(source = "semanas_de_duracion", target = "duracionSemanas")
    void updateEntrenmiento(ActualizarEntrenamientoDto entrenamientoDto, @MappingTarget EntrenamientoEntity entrenamientoEntity);
}
