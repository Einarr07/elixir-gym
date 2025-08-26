package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;

import java.util.List;
import java.util.Optional;

public interface IEjercicioRepository {

    List<EjercicioDto> findAllEjercicio();

    Optional<EjercicioDto> findEjercicioById(long id);

    EjercicioDto saveEjercicio(EjercicioDto ejercicioDto);

    Optional<EjercicioDto> updateEjercicio(long id, ActualizarEjercicioDto ejercicioDto);

    void deleteById(long id);
}
