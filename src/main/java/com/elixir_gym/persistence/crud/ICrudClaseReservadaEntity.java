package com.elixir_gym.persistence.crud;

import com.elixir_gym.persistence.entity.ClaseReservadaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICrudClaseReservadaEntity extends CrudRepository<ClaseReservadaEntity, Long> {

    List<ClaseReservadaEntity> findAllByUsuario_IdUsuario(Long usuarioId);

    boolean existsByIdReservaAndUsuario_IdUsuario(Long idReserva, Long usuarioId);
}
