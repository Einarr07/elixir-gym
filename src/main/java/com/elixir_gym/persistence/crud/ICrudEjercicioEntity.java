package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.EjercicioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudEjercicioEntity extends CrudRepository<EjercicioEntity, Long> {
}
