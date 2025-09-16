package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;
import com.elixir_gym.domain.exception.ClaseException;
import com.elixir_gym.persistence.repository.ClaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaseService {

    private final ClaseRepository claseRepository;

    public List<ClaseDto> getAll(){
        return claseRepository.findAll();
    }

    public ClaseDto getById(long id){
        return claseChecker(id);
    }

    public ClaseDto save(ClaseDto claseDto){
        return claseRepository.save(claseDto);
    }

    public ClaseDto updateClase(long id, ActualizarClaseDto actualizarClaseDto){
        return claseRepository.update(id, actualizarClaseDto)
                .orElseThrow(() -> new ClaseException(id));
    }

    public void deleteById(long id){
        claseChecker(id);
        claseRepository.deleteById(id);
    }

    public ClaseDto claseChecker(long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new ClaseException(id));
    }
}
