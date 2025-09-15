package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;
import com.elixir_gym.persistence.entity.ProgresoEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProgresoMapper {

    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "grasaCorporal", target = "grasa_corporal")
    @Mapping(source = "observaciones", target = "observaciones")
    @Mapping(source = "usuario", target = "idUsuario")
    ProgresoDto toDto(ProgresoEntity entity);
    List<ProgresoDto> toDtoList(Iterable<ProgresoEntity> entities);

    @InheritInverseConfiguration
    ProgresoEntity toEntity(ProgresoDto progresoDto);

    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "grasa_corporal", target = "grasaCorporal")
    @Mapping(source = "observaciones", target = "observaciones")
    @Mapping(source = "idUsuario", target = "usuario")
    void updateProgreso(ActualizarProgresoDto actualizarProgresoDto, @MappingTarget ProgresoEntity progresoEntity);

    // Entidad -> Dto
    default Long map(UsuarioEntity usuarioEntity) {
        return (usuarioEntity == null) ? null : usuarioEntity.getIdUsuario();
    }

    // Dto -> Entidad
    default UsuarioEntity map(Long idUsuario) {
        if (idUsuario == null) return null;
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }

}
