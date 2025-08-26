package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.persistence.entity.GrupoMuscularEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IGrupoMuscularMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    GrupoMuscularDto toDto(GrupoMuscularEntity grupoMuscularEntity);
    List<GrupoMuscularDto> toDtoList(Iterable<GrupoMuscularEntity> grupoMuscularEntities);

    @InheritInverseConfiguration
    GrupoMuscularEntity toEntity(GrupoMuscularDto grupoMuscularDto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(target = "ejercicio", ignore = true)
    void updateGrupoMuscular(ActualizarGrupoMuscularDto actualizarGrupoMuscularDto, @MappingTarget GrupoMuscularEntity grupoMuscularEntity);
}
