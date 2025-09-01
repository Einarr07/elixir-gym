package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;

import java.util.List;
import java.util.Optional;

public interface IEntrenamientoEjercicioRepository {

    List<EntrenamientoEjercicioDto> findAllEntrenamientoEjercicio();

    Optional<EntrenamientoEjercicioDto> findById(Long idEntrenamiento, Long idEjercicio);

    EntrenamientoEjercicioDto save(EntrenamientoEjercicioDto entrenamientoDto);

    Optional<EntrenamientoEjercicioDto> update(Long idEntrenamiento, Long idEjercicio,
                                               ActualizarEntrenamientoEjercicioDto entrenamientoDto);

    void deleteById(Long idEntrenamiento, Long idEjercicio);
}
