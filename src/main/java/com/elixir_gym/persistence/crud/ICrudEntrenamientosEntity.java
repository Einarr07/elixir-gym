package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudEntrenamientosEntity extends CrudRepository<EntrenamientoEntity, Long> {
}
