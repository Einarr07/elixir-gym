package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.RolDto;
import com.elixir_gym.persistence.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRolMapper {

    @Mapping(source = "nombreRol", target = "rol")
    RolDto toDto(RolEntity rolEntity);
    List<RolDto> toDtoList(Iterable<RolEntity> rolEntities);
}
