// En: persistence/mapper/IEjercicioAsignadoMapper.java
package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.EjercicioAsignadoDto;
import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEjercicioAsignadoMapper {
    
    @Mapping(source = "entrenamiento.idEntrenamiento", target = "idEntrenamiento")
    @Mapping(source = "ejercicio.idEjercicio", target = "idEjercicio")
    @Mapping(source = "ejercicio.nombre", target = "nombre")
    @Mapping(source = "series", target = "series")
    @Mapping(source = "repeticiones", target = "repeticiones")
    @Mapping(source = "pesoSugerido", target = "peso_sugerido")
    @Mapping(source = "descansoSegundos", target = "descanso_segundos")
    EjercicioAsignadoDto toDto(EntrenamientoEjercicioEntity entity);


    List<EjercicioAsignadoDto> toDtoList(List<EntrenamientoEjercicioEntity> entities);
}