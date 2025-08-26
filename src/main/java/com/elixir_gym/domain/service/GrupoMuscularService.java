package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.domain.repository.IGrupoMuscularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrupoMuscularService {

    private final IGrupoMuscularRepository grupoMuscularRepository;

    public List<GrupoMuscularDto> findAll() {
        return grupoMuscularRepository.findAll();
    }

    public Optional<GrupoMuscularDto> findById(long id) {
        return grupoMuscularRepository.findById(id);
    }

    public GrupoMuscularDto save(GrupoMuscularDto dto) {
        return grupoMuscularRepository.save(dto);
    }

    public Optional<GrupoMuscularDto> update(long id, ActualizarGrupoMuscularDto actualizarGrupoMuscularDto) {
        Optional<GrupoMuscularDto> grupoExistente = this.findById(id);
        if (grupoExistente.isEmpty()) {
            return Optional.empty();
        }

        return grupoMuscularRepository.update(id, actualizarGrupoMuscularDto);
    }

    public void deleteGrupoMuscular(long id) {
        grupoMuscularRepository.delteById(id);
    }
}
