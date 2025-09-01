package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;
import com.elixir_gym.persistence.entity.EjercicioEntity;
import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEntrenamientoEjercicioMapper {

    // ===== DTO Mapping =====
    @Mapping(source = "id.idEntrenamiento", target = "idEntrenamiento")
    @Mapping(source = "id.idEjercicio", target = "idEjercicio")
    @Mapping(source = "series", target = "series")
    @Mapping(source = "repeticiones", target = "repeticiones")
    @Mapping(source = "pesoSugerido", target = "peso_sugerido")
    @Mapping(source = "descansoSegundos", target = "descanso_segundos")
    EntrenamientoEjercicioDto toDto(EntrenamientoEjercicioEntity entrenamientoEjercicioEntity);

    List<EntrenamientoEjercicioDto> toDtoList(Iterable<EntrenamientoEjercicioEntity> entrenamientoEjercicioEntities);

    // ===== Entity Mapping =====
    default EntrenamientoEjercicioEntity toEntity(EntrenamientoEjercicioDto dto) {
        if (dto == null) return null;

        EntrenamientoEjercicioEntity entity = new EntrenamientoEjercicioEntity();

        // Inicializar EmbeddedId
        EntrenamientoEjercicioId id = new EntrenamientoEjercicioId();
        id.setIdEntrenamiento(dto.idEntrenamiento());
        id.setIdEjercicio(dto.idEjercicio());
        entity.setId(id);

        // Setear relaciones
        entity.setEntrenamiento(toEntrenamientoEntity(dto.idEntrenamiento()));
        entity.setEjercicio(toEjercicioEntity(dto.idEjercicio()));

        // Otros campos
        entity.setSeries(dto.series());
        entity.setRepeticiones(dto.repeticiones());
        entity.setPesoSugerido(dto.peso_sugerido());
        entity.setDescansoSegundos(dto.descanso_segundos());

        return entity;
    }

    default EntrenamientoEntity toEntrenamientoEntity(Long id) {
        if (id == null) return null;
        EntrenamientoEntity e = new EntrenamientoEntity();
        e.setIdEntrenamiento(id);
        return e;
    }

    default EjercicioEntity toEjercicioEntity(Long id) {
        if (id == null) return null;
        EjercicioEntity e = new EjercicioEntity();
        e.setIdEjercicio(id);
        return e;
    }

    // ===== Actualización parcial =====
    @Mapping(source = "series", target = "series")
    @Mapping(source = "repeticiones", target = "repeticiones")
    @Mapping(source = "peso_sugerido", target = "pesoSugerido")
    @Mapping(source = "descanso_segundos", target = "descansoSegundos")
    void updateEjercicio(ActualizarEntrenamientoEjercicioDto entrenamientoEjercicioDto,
                         @MappingTarget EntrenamientoEjercicioEntity entrenamientoEjercicioEntity);
}
