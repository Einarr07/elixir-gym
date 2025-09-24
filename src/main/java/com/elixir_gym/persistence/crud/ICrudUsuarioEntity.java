package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICrudUsuarioEntity extends CrudRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email);
}
