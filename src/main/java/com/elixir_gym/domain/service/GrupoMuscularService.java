package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.domain.exception.GrupoMuscularInexistenteException;
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
        return existenceChecker(id);
    }

    public GrupoMuscularDto save(GrupoMuscularDto dto) {
        return grupoMuscularRepository.save(dto);
    }

    public Optional<GrupoMuscularDto> update(long id, ActualizarGrupoMuscularDto actualizarGrupoMuscularDto) {
        existenceChecker(id);

        return grupoMuscularRepository.update(id, actualizarGrupoMuscularDto);
    }

    public void deleteGrupoMuscular(long id) {

        existenceChecker(id);

        grupoMuscularRepository.delteById(id);
    }

    public Optional<GrupoMuscularDto> existenceChecker(long id) {
        Optional<GrupoMuscularDto> grupoExistente = grupoMuscularRepository.findById(id);

        if (grupoExistente.isEmpty()) {
            throw new GrupoMuscularInexistenteException(id);
        }

        return grupoExistente;
    }
}
