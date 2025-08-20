package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.RolDto;
import com.elixir_gym.domain.repository.IRolRepository;
import com.elixir_gym.persistence.crud.ICrudRolEntity;
import com.elixir_gym.persistence.entity.RolEntity;
import com.elixir_gym.persistence.mapper.IRolMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RolEntityRepository implements IRolRepository {

    private final ICrudRolEntity crudRolEntity;
    private final IRolMapper rolMapper;


    @Override
    public List<RolDto> findAll() {
        return rolMapper.toDtoList(crudRolEntity.findAll());
    }

    @Override
    public Optional<RolDto> findById(Long id) {
        return crudRolEntity.findById(id).map(rolMapper::toDto);
    }

}
