package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.updates.ActualizarUsuarioDto;
import com.elixir_gym.domain.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {

    List<UsuarioDto> findAll();

    Optional<UsuarioDto> findById(long id);

    Optional<UsuarioDto> findByEmail(String correo);

    UsuarioDto save(UsuarioDto usuarioDto);

    Optional<UsuarioDto> update(long id, ActualizarUsuarioDto usuarioDto);

    void deleteById(long id);
}
