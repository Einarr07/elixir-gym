package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;
import com.elixir_gym.domain.exception.EquipoIniexistenteExeption;
import com.elixir_gym.persistence.repository.EquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public List<EquipoDto> findAll() {
        return equipoRepository.findAll();
    }

    public EquipoDto findById(long id) {
        return existenceCheker(id);
    }

    public EquipoDto save(EquipoDto equipoDto) {
        return equipoRepository.save(equipoDto);
    }

    public EquipoDto update(long id, ActualizarEquipoDto equipoDto) {
        return equipoRepository.update(id, equipoDto)
                .orElseThrow(() -> new EquipoIniexistenteExeption(id));
    }

    public void delete(long id) {
        existenceCheker(id);
        equipoRepository.delteById(id);
    }

    public EquipoDto existenceCheker(long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new EquipoIniexistenteExeption(id));
    }
}
