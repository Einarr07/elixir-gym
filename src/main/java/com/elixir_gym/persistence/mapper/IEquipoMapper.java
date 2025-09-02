package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;
import com.elixir_gym.persistence.entity.EquipoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEquipoMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "ejercicios", target = "ejercicios")
    EquipoDto toDto(EquipoEntity equipoEntity);
    List<EquipoDto> toDtoList(Iterable<EquipoEntity> equipoEntities);

    @InheritInverseConfiguration
    EquipoEntity toEntity(EquipoDto equipoDto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "ejercicios", target = "ejercicios")
    void updateEquipo(ActualizarEquipoDto actualizarEquipoDto, @MappingTarget EquipoEntity equipoEntity);
}
