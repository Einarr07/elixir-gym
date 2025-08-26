package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.repository.IEjercicioRepository;
import com.elixir_gym.persistence.crud.ICrudEjercicioEntity;
import com.elixir_gym.persistence.entity.EjercicioEntity;
import com.elixir_gym.persistence.mapper.IEjercicioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EjercicioRepository implements IEjercicioRepository {

    private final ICrudEjercicioEntity crudEjercicioEntity;
    private final IEjercicioMapper ejercicioMapper;

    @Override
    public List<EjercicioDto> findAllEjercicio() {
        return ejercicioMapper.toDtoList(crudEjercicioEntity.findAll());
    }

    @Override
    public Optional<EjercicioDto> findEjercicioById(long id) {
        return crudEjercicioEntity.findById(id).map(ejercicioMapper::toDto);
    }

    @Override
    public EjercicioDto saveEjercicio(EjercicioDto ejercicioDto) {
        EjercicioEntity ejercicioEntity = ejercicioMapper.toEntity(ejercicioDto);

        return ejercicioMapper.toDto(crudEjercicioEntity.save(ejercicioEntity));
    }

    @Override
    public Optional<EjercicioDto> updateEjercicio(long id, ActualizarEjercicioDto ejercicioDto) {

        return crudEjercicioEntity.findById(id).map(ejercicioExistente -> {
            ejercicioMapper.updateEjercicio(ejercicioDto, ejercicioExistente);
            return ejercicioMapper.toDto(crudEjercicioEntity.save(ejercicioExistente));
        });
    }

    @Override
    public void deleteById(long id) {
        crudEjercicioEntity.deleteById(id);
    }
}
