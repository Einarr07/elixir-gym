package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;
import com.elixir_gym.domain.repository.IHorarioClaseRepository;
import com.elixir_gym.persistence.crud.ICrudHorarioClaseEntity;
import com.elixir_gym.persistence.entity.HorarioClaseEntity;
import com.elixir_gym.persistence.mapper.IHorarioClaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HorarioClaseRepository implements IHorarioClaseRepository {


    private final ICrudHorarioClaseEntity crudHorarioClase;
    private final IHorarioClaseMapper horarioClaseMapper;


    @Override
    public List<HorarioClaseDto> findAll() {
        return horarioClaseMapper.toDtoList(crudHorarioClase.findAll());
    }

    @Override
    public Optional<HorarioClaseDto> findById(long id) {
        return crudHorarioClase.findById(id).map(horarioClaseMapper::toDto);
    }

    @Override
    public HorarioClaseDto save(HorarioClaseDto horarioClaseDto) {

        HorarioClaseEntity horarioClaseEntity = horarioClaseMapper.toEntity(horarioClaseDto);
        return horarioClaseMapper.toDto(crudHorarioClase.save(horarioClaseEntity));
    }

    @Override
    public Optional<HorarioClaseDto> update(long id, ActualizarHorarioClaseDto horarioClaseDto) {
        return crudHorarioClase.findById(id)
                .map(horarioClaseEntity -> {
                    horarioClaseMapper.updateHorarioClase(horarioClaseDto, horarioClaseEntity);
                    return horarioClaseMapper.toDto(crudHorarioClase.save(horarioClaseEntity));
                });
    }

    @Override
    public void deleteById(long id) {
        crudHorarioClase.deleteById(id);
    }
}
