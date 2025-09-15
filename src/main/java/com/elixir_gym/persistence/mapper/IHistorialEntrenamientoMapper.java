package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;
import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import com.elixir_gym.persistence.entity.HistorialEntrenamientoEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHistorialEntrenamientoMapper {

    @Mapping(source = "entrenamiento", target = "idEntrenamiento")
    @Mapping(source = "usuario", target = "idUsuario")
    @Mapping(source = "fechaInicio", target = "inicio")
    @Mapping(source = "fechaFin", target = "fin")
    @Mapping(source = "completado", target = "completado")
    HistorialEntrenamientoDto toDto(HistorialEntrenamientoEntity historialEntrenamiento);
    List<HistorialEntrenamientoDto> toDtoList(Iterable<HistorialEntrenamientoEntity> historialEntrenamientoEntities);

    @InheritInverseConfiguration
    HistorialEntrenamientoEntity toEntity(HistorialEntrenamientoDto dto);

    @Mapping(source= "idEntrenamiento", target = "entrenamiento")
    @Mapping(source = "idUsuario", target = "usuario")
    @Mapping(source = "inicio", target = "fechaInicio")
    @Mapping(source = "fin", target = "fechaFin")
    @Mapping(source = "completado", target = "completado")
    void updateHistorialEntrenamiento(ActualizarHistorialEntrenamientoDto dto,
                                      @MappingTarget HistorialEntrenamientoEntity historialEntrenamiento);

    // 🔽 Métodos auxiliares (DTO → Entidad)
    default EntrenamientoEntity mapEntrenamiento(Long id) {
        if (id == null) return null;
        EntrenamientoEntity e = new EntrenamientoEntity();
        e.setIdEntrenamiento(id);
        return e;
    }

    default UsuarioEntity mapUsuario(Long id) {
        if (id == null) return null;
        UsuarioEntity u = new UsuarioEntity();
        u.setIdUsuario(id);
        return u;
    }

    // 🔽 Métodos inversos (Entidad → DTO)
    default Long mapEntrenamiento(EntrenamientoEntity entity) {
        return (entity == null) ? null : entity.getIdEntrenamiento();
    }

    default Long mapUsuario(UsuarioEntity entity) {
        return (entity == null) ? null : entity.getIdUsuario();
    }
}
