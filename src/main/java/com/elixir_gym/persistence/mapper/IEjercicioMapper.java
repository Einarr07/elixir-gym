package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.persistence.entity.EjercicioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring", uses = {IGrupoMuscularMapper.class, IEquipoMapper.class})
public interface IEjercicioMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "videoUrl", target = "video")
    @Mapping(source = "imagenUrl", target = "imagen")
    @Mapping(source = "equipoNecesario", target = "equipo_necesario")
    @Mapping(source = "grupo", target = "grupo_muscular")
    @Mapping(source = "equipos", target = "equipos")
    EjercicioDto toDto(EjercicioEntity ejercicioEntity);
    List<EjercicioDto> toDtoList(Iterable<EjercicioEntity> ejercicioEntities);

    @InheritInverseConfiguration
    EjercicioEntity toEntity(EjercicioDto ejercicioDto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "video", target = "videoUrl")
    @Mapping(source = "imagen", target = "imagenUrl")
    @Mapping(source = "equipo_necesario", target = "equipoNecesario")
    @Mapping(source = "grupo_muscular", target = "grupo")
    @Mapping(source = "equipos", target = "equipos")
    void updateEjercicio(ActualizarEjercicioDto ejercicioDto, @MappingTarget EjercicioEntity ejercicioEntity);
}
