package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.RolDto;
import com.elixir_gym.persistence.entity.RolEntity;

import java.util.List;
import java.util.Optional;

public interface IRolRepository {

    public List<RolDto> findAll();

    public Optional<RolDto> findById(Long id);
}
