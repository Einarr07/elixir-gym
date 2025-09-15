package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;
import com.elixir_gym.domain.exception.ProgresoException;
import com.elixir_gym.persistence.repository.ProgresoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgresoService {

    private final ProgresoRepository progresoRepository;

    public List<ProgresoDto> getAll() {
        return progresoRepository.findAll();
    }

    public ProgresoDto getById(long id){
        return progresoChecker(id);
    }

    public ProgresoDto save(ProgresoDto progresoDto){
        return progresoRepository.save(progresoDto);
    }

    public ProgresoDto update(long id, ActualizarProgresoDto progresoDto) {
        return progresoRepository.update(id, progresoDto)
                .orElseThrow(() -> new ProgresoException(id));
    }

    public void deleteById(long id) {
        progresoRepository.deleteById(id);
    }

    public ProgresoDto progresoChecker(long id) {
        return progresoRepository.findById(id)
                .orElseThrow(() -> new ProgresoException(id));
    }
}
