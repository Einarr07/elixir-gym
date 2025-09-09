package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;
import com.elixir_gym.domain.exception.HistorialEntrenamientoException;
import com.elixir_gym.persistence.repository.HistorialEntrenamientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistorialEntrenemaientoService {

    private HistorialEntrenamientoRepository historialEntrenamientoRepository;

    public List<HistorialEntrenamientoDto> getAllHistorialEntrenamiento() {
        return historialEntrenamientoRepository.findAll();
    }

    public HistorialEntrenamientoDto getById(long id) {
        return historialCheker(id);
    }

    public HistorialEntrenamientoDto save(HistorialEntrenamientoDto dto) {
        return historialEntrenamientoRepository.save(dto);
    }

    public HistorialEntrenamientoDto update(long id, ActualizarHistorialEntrenamientoDto dto){
        return historialEntrenamientoRepository.update(id, dto)
                .orElseThrow(() -> new HistorialEntrenamientoException(id));
    }

    public void deleteById(long id) {
        historialCheker(id);
        historialEntrenamientoRepository.deleteById(id);
    }

    public HistorialEntrenamientoDto historialCheker(long id) {
        return historialEntrenamientoRepository.findById(id)
                .orElseThrow(() -> new HistorialEntrenamientoException(id));
    }

}
