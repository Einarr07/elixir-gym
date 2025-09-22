package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;
import com.elixir_gym.persistence.entity.ClaseReservadaEntity;
import com.elixir_gym.persistence.entity.HorarioClaseEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClaseReservadaMapper {

    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "horario", target = "horario")
    @Mapping(source = "fechaReserva", target = "reservacion")
    @Mapping(source = "estadoReserva", target = "estado")
    ClaseReservadaDto toDto(ClaseReservadaEntity claseReservadaEntity);

    List<ClaseReservadaDto> toDtoList(Iterable<ClaseReservadaEntity> claseReservadaEntities);

    @InheritInverseConfiguration
    ClaseReservadaEntity toEntity(ClaseReservadaDto dto);

    @Mapping(source = "usuario.idUsuario", target = "usuario", qualifiedByName = "mapClaseUsuario")
    @Mapping(source = "horario.idHorario", target = "horario", qualifiedByName = "mapHorarioClase")
    @Mapping(source = "reservacion", target = "fechaReserva")
    @Mapping(source = "estado", target = "estadoReserva")
    void updateClaseReservada(ActualizarClaseReservadaDto actualizarClaseReservada,
                              @MappingTarget ClaseReservadaEntity claseReservadaEntity);

    // Dto -> Entity
    @Named("mapClaseUsuario")
    default UsuarioEntity mapClaseUsuario(Long id){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(id);
        return usuarioEntity;
    }

    @Named("mapHorarioClase")
    default HorarioClaseEntity mapHorarioClase(Long id){
        HorarioClaseEntity horarioClaseEntity = new HorarioClaseEntity();
        horarioClaseEntity.setIdHorario(id);
        return horarioClaseEntity;
    }

    // Entity -> Dto
    default Long mapIdUsuario(UsuarioEntity usuarioEntity){
        return (usuarioEntity == null) ? null : usuarioEntity.getIdUsuario();
    }

    default Long mapIdHorarioClase(HorarioClaseEntity horarioClaseEntity){
        return (horarioClaseEntity == null) ? null : horarioClaseEntity.getIdHorario();
    }
}
