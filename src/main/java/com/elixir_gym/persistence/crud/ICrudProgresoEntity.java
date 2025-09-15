package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.ProgresoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudProgresoEntity extends CrudRepository<ProgresoEntity, Long> {
}
