package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;
import com.elixir_gym.persistence.entity.ClaseEntity;
import com.elixir_gym.persistence.entity.HorarioClaseEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHorarioClaseMapper {

    @Mapping(source = "fechaClase", target = "fecha")
    @Mapping(source = "horaInicio", target = "hora_inicio")
    @Mapping(source = "horaFin", target = "hora_fin")
    @Mapping(source = "clase", target = "clase")
    @Mapping(source = "usuario", target = "entrenador")
    HorarioClaseDto toDto(HorarioClaseEntity horarioClaseEntity);

    List<HorarioClaseDto> toDtoList(Iterable<HorarioClaseEntity> horarioClaseEntityIterable);

    @InheritInverseConfiguration
    HorarioClaseEntity toEntity(HorarioClaseDto horarioClaseDto);

    @Mapping(source = "fecha", target = "fechaClase")
    @Mapping(source = "hora_inicio", target = "horaInicio")
    @Mapping(source = "hora_fin", target = "horaFin")
    @Mapping(source = "clase.idClase", target = "clase", qualifiedByName = "mapClase")
    @Mapping(source = "entrenador.idUsuario", target = "usuario", qualifiedByName = "mapClase")
    void updateHorarioClase(ActualizarHorarioClaseDto actualizarHorarioClaseDto,
                            @MappingTarget HorarioClaseEntity horarioClaseEntity);

    // Dto -> Entity
    @Named("mapClase")
    default ClaseEntity mapClase(Long id){
        if (id == null) return null;
        ClaseEntity claseEntity = new ClaseEntity();
        claseEntity.setIdClase(id);
        return claseEntity;
    }

    @Named("mapClase")
    default UsuarioEntity mapUsuario(Long id){
        if (id == null) return null;
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(id);
        return usuarioEntity;
    }

    // Entity -> Dto
    default Long mapIdUsuario(ClaseEntity claseEntity){
        return (claseEntity == null) ? null : claseEntity.getIdClase();
    }

    default Long mapIdUsuario(UsuarioEntity usuarioEntity){
        return (usuarioEntity == null) ? null : usuarioEntity.getIdUsuario();
    }

    default String mapStringUsuario(UsuarioEntity usuarioEntity){
        return (usuarioEntity == null) ? null : usuarioEntity.getNombre();
    }
}
