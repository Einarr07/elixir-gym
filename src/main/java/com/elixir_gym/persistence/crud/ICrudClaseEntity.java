package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.ClaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudClaseEntity extends CrudRepository<ClaseEntity, Long> {
}
