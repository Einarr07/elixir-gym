package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.exception.EjercicioInexistenteException;
import com.elixir_gym.domain.repository.IEjercicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EjercicioService {

    private final IEjercicioRepository ejercicioRepository;

    public List<EjercicioDto> findAll() {
        return ejercicioRepository.findAllEjercicio();
    }

    public Optional<EjercicioDto> findById(long id) {
        return existenceChecker(id);
    }

    public EjercicioDto save(EjercicioDto ejercicioDto) {
        return ejercicioRepository.saveEjercicio(ejercicioDto);
    }

    public Optional<EjercicioDto> updateEjercicio(long id, ActualizarEjercicioDto actualizarEjercicioDto) {
        existenceChecker(id);

        return ejercicioRepository.updateEjercicio(id, actualizarEjercicioDto);
    }

    public void deleteEjercicioById(long id) {
        existenceChecker(id);
        ejercicioRepository.deleteById(id);
    }

    public Optional<EjercicioDto> existenceChecker(long id) {
        Optional<EjercicioDto> ejercicioExistente = ejercicioRepository.findEjercicioById(id);

        if (ejercicioExistente.isEmpty()) {
            throw new EjercicioInexistenteException(id);
        }

        return ejercicioExistente;
    }
}
