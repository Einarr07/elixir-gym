package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudUsuarioEntity extends CrudRepository<UsuarioEntity, Long> {

    UsuarioEntity findByEmail(String email);
}
