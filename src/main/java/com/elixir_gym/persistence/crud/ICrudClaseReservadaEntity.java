package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.ClaseReservadaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudClaseReservadaEntity extends CrudRepository<ClaseReservadaEntity, Long> {
}
