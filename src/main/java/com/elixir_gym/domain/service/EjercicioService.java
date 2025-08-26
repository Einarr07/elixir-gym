package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.repository.IEjercicioRepository;
import com.elixir_gym.persistence.repository.EjercicioRepository;
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
        return ejercicioRepository.findEjercicioById(id);
    }

    public EjercicioDto save(EjercicioDto ejercicioDto) {
        return ejercicioRepository.saveEjercicio(ejercicioDto);
    }

    public Optional<EjercicioDto> updateEjercicio(long id, ActualizarEjercicioDto actualizarEjercicioDto) {
        Optional<EjercicioDto> ejercicioExistente = ejercicioRepository.findEjercicioById(id);

        if (ejercicioExistente.isEmpty()) {
            return Optional.empty();
        }

        return ejercicioRepository.updateEjercicio(id, actualizarEjercicioDto);
    }

    public void deleteEjercicioById(long id) {
        ejercicioRepository.deleteById(id);
    }
}
