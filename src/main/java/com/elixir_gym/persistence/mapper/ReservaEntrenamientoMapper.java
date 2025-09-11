package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;
import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import com.elixir_gym.persistence.entity.ReservaEntrenamientoEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaEntrenamientoMapper {

    @Mapping(source = "fechaReserva", target = "fecha_reserva")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "entrenamiento", target = "idEntrenamiento")
    @Mapping(source = "usuario", target = "idUsuario")
    ReservaEntrenamientoDto toDto(ReservaEntrenamientoEntity reservasEntrenamiento);
    List<ReservaEntrenamientoDto> toDtoList(Iterable<ReservaEntrenamientoEntity> reservasEntrenamientos);

    @InheritInverseConfiguration
    ReservaEntrenamientoEntity toEntity(ReservaEntrenamientoDto dto);

    @Mapping(source = "fecha_reserva", target = "fechaReserva")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "idEntrenamiento", target = "entrenamiento")
    @Mapping(source = "idUsuario", target = "usuario")
    void updateReservaEntrenamiento(ActualizarReservaEntrenamientoDto actualizarReserva,
                                    @MappingTarget ReservaEntrenamientoEntity reservasEntrenamiento);


    // Dto -> Entidad
    default EntrenamientoEntity mapEntrenamiento(Long id){
        if(id == null) return null;
        EntrenamientoEntity entrenamiento = new EntrenamientoEntity();
        entrenamiento.setIdEntrenamiento(id);
        return entrenamiento;
    }

    default UsuarioEntity mapUsuario(Long id){
        if(id == null) return null;
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(id);
        return usuario;
    }

    // Entidad -> Dto
    default Long mapEntrenamiento(EntrenamientoEntity entrenamiento){
        return (entrenamiento == null) ? null : entrenamiento.getIdEntrenamiento();
    }

    default Long mapUsuario(UsuarioEntity usuario){
        return (usuario == null) ? null : usuario.getIdUsuario();
    }

}
