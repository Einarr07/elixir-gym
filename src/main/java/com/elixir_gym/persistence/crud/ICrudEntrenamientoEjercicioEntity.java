package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICrudEntrenamientoEjercicioEntity extends CrudRepository<EntrenamientoEjercicioEntity, EntrenamientoEjercicioId> {
    List<EntrenamientoEjercicioEntity> findByEntrenamiento_IdEntrenamiento(Long id);

}
