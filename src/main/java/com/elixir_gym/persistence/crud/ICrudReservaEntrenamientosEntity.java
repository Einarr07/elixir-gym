package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.ReservaEntrenamientoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudReservaEntrenamientosEntity extends CrudRepository<ReservaEntrenamientoEntity, Long> {
}
