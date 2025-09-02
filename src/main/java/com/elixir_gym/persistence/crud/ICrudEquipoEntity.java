package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.EquipoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudEquipoEntity extends CrudRepository<EquipoEntity, Long> {
}
