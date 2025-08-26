package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.exception.EjercicioInexistenteException;
import com.elixir_gym.domain.exception.EntrenamientoInexistenteException;
import com.elixir_gym.persistence.repository.EntrenamientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntrenamientoService {

    private final EntrenamientoRepository entrenamientoRepository;

    public List<EntrenamientoDto> findAll() {
        return entrenamientoRepository.findAll();
    }

    public Optional<EntrenamientoDto> findById(long id) {
        return existenceChecker(id);
    }

    public EntrenamientoDto save(EntrenamientoDto dto) {
        return entrenamientoRepository.save(dto);
    }

    public Optional<EntrenamientoDto> update(long id, ActualizarEntrenamientoDto dto) {
        existenceChecker(id);
        return entrenamientoRepository.update(id, dto);
    }

    public void deleteById(long id) {
        existenceChecker(id);
        entrenamientoRepository.deleteById(id);
    }

    public Optional<EntrenamientoDto> existenceChecker(long id) {
        Optional<EntrenamientoDto> ejercicioExistente = entrenamientoRepository.findById(id);

        if (ejercicioExistente.isEmpty()) {
            throw new EntrenamientoInexistenteException(id);
        }

        return ejercicioExistente;
    }

}
