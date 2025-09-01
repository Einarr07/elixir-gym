package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;
import com.elixir_gym.domain.exception.EjercicioInexistenteException;
import com.elixir_gym.domain.exception.EntrenamientoEjercicioException;
import com.elixir_gym.domain.exception.EntrenamientoInexistenteException;
import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import com.elixir_gym.persistence.repository.EjercicioRepository;
import com.elixir_gym.persistence.repository.EntrenamientoEjercicioRepository;
import com.elixir_gym.persistence.repository.EntrenamientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntrenamientoEjercicioService {

    private final EntrenamientoEjercicioRepository repository;
    private final EntrenamientoRepository entrenamientoRepository;
    private final EjercicioRepository ejercicioRepository;

    public List<EntrenamientoEjercicioDto> findAll() {
        return repository.findAllEntrenamientoEjercicio();
    }

    public EntrenamientoEjercicioDto findById(long idEntrenamiento, long idEjercicio) {
        return existenceChecker(idEntrenamiento, idEjercicio);
    }

    public EntrenamientoEjercicioDto save(EntrenamientoEjercicioDto dto) {
        entrenamientoRepository.findById(dto.idEntrenamiento())
                .orElseThrow(() -> new EntrenamientoInexistenteException(dto.idEntrenamiento()));

        ejercicioRepository.findEjercicioById(dto.idEjercicio())
                .orElseThrow(() -> new EjercicioInexistenteException(dto.idEjercicio()));

        return repository.save(dto);
    }

    public EntrenamientoEjercicioDto updateEntrenamientoEjericio(
            long idEntrenamiento,
            long idEjercicio,
            ActualizarEntrenamientoEjercicioDto entrenamientoDto
    ){
        existenceChecker(idEntrenamiento, idEjercicio);
        return repository.update(idEntrenamiento, idEjercicio, entrenamientoDto)
                .orElseThrow(() -> new EntrenamientoEjercicioException(idEntrenamiento, idEjercicio));
    }

    public void deleteById(long idEntrenamiento, long idEjercicio) {
        repository.deleteById(idEntrenamiento, idEjercicio);
    }

    public EntrenamientoEjercicioDto existenceChecker(long idEntrenamiento, long idEjercicio) {
        return repository.findById(idEntrenamiento, idEjercicio)
                .orElseThrow(() -> new EntrenamientoEjercicioException(idEntrenamiento, idEjercicio));
    }
}
