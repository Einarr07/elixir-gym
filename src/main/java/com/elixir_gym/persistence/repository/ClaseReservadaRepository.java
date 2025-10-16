package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;
import com.elixir_gym.domain.repository.IClaseReservadaRepositoroy;
import com.elixir_gym.persistence.crud.ICrudClaseReservadaEntity;
import com.elixir_gym.persistence.entity.ClaseReservadaEntity;
import com.elixir_gym.persistence.mapper.IClaseReservadaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClaseReservadaRepository implements IClaseReservadaRepositoroy {

    private final ICrudClaseReservadaEntity crudClaseReservadaEntity;
    private final IClaseReservadaMapper claseReservadaMapper;

    @Override
    public List<ClaseReservadaDto> findAll() {
        return claseReservadaMapper.toDtoList(crudClaseReservadaEntity.findAll());
    }

    @Override
    public Optional<ClaseReservadaDto> findById(Long id) {
        return crudClaseReservadaEntity.findById(id).map(claseReservadaMapper::toDto);
    }

    @Override
    public ClaseReservadaDto save(ClaseReservadaDto dto) {
        ClaseReservadaEntity claseReservadaEntity = claseReservadaMapper.toEntity(dto);
        return claseReservadaMapper.toDto(crudClaseReservadaEntity.save(claseReservadaEntity));
    }

    @Override
    public Optional<ClaseReservadaDto> update(long id, ActualizarClaseReservadaDto dto) {
        return crudClaseReservadaEntity.findById(id)
                .map(claseReservadaEntity -> {
                    claseReservadaMapper.updateClaseReservada(dto, claseReservadaEntity);
                    return claseReservadaMapper.toDto(crudClaseReservadaEntity.save(claseReservadaEntity));
                });
    }

    @Override
    public List<ClaseReservadaDto> findByUser(long id) {
        return claseReservadaMapper.toDtoList(crudClaseReservadaEntity.findAllByUsuario_IdUsuario(id));
    }


    @Override
    public void deleteById(long id) {
        crudClaseReservadaEntity.deleteById(id);
    }
}
