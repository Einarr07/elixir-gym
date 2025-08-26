package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import org.springframework.data.repository.CrudRepository;

public interface ICrudEntrenamientoEjercicioEntity extends CrudRepository<EntrenamientoEjercicioEntity, EntrenamientoEjercicioId> {
}
