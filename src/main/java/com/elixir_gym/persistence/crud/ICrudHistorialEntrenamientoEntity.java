package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.HistorialEntrenamientoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudHistorialEntrenamientoEntity extends CrudRepository<HistorialEntrenamientoEntity, Long> {
}
