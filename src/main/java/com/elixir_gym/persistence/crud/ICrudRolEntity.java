package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudRolEntity extends CrudRepository<RolEntity, Long> {

}
