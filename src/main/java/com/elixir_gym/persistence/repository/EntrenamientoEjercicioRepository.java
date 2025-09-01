package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;
import com.elixir_gym.domain.repository.IEntrenamientoEjercicioRepository;
import com.elixir_gym.persistence.crud.ICrudEntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.EntrenamientoEjercicioEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import com.elixir_gym.persistence.mapper.IEntrenamientoEjercicioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EntrenamientoEjercicioRepository implements IEntrenamientoEjercicioRepository {

    private final ICrudEntrenamientoEjercicioEntity crudEntrenamientoEjercicioEntity;
    private final IEntrenamientoEjercicioMapper entrenamientoEjercicioMapper;

    @Override
    public List<EntrenamientoEjercicioDto> findAllEntrenamientoEjercicio() {
        return entrenamientoEjercicioMapper.toDtoList(crudEntrenamientoEjercicioEntity.findAll());
    }

    @Override
    public Optional<EntrenamientoEjercicioDto> findById(Long idEntrenamiento, Long idEjercicio) {
        EntrenamientoEjercicioId id = new EntrenamientoEjercicioId(idEntrenamiento, idEjercicio);
        return crudEntrenamientoEjercicioEntity.findById(id).map(entrenamientoEjercicioMapper::toDto);
    }

    @Override
    public EntrenamientoEjercicioDto save(EntrenamientoEjercicioDto entrenamientoDto) {
        EntrenamientoEjercicioEntity entrenamientoEjercicioEntity = entrenamientoEjercicioMapper.toEntity(entrenamientoDto);

        return entrenamientoEjercicioMapper.toDto(crudEntrenamientoEjercicioEntity.save(entrenamientoEjercicioEntity));
    }

    @Override
    public Optional<EntrenamientoEjercicioDto> update(Long idEntrenamiento, Long idEjercicio,
                                                      ActualizarEntrenamientoEjercicioDto entrenamientoDto) {
        EntrenamientoEjercicioId id = new EntrenamientoEjercicioId(idEntrenamiento, idEjercicio);

        return crudEntrenamientoEjercicioEntity.findById(id).map(entrenamientoEjercicioExistente -> {
            entrenamientoEjercicioMapper.updateEjercicio(entrenamientoDto, entrenamientoEjercicioExistente);
            return entrenamientoEjercicioMapper.toDto(
                    crudEntrenamientoEjercicioEntity.save(entrenamientoEjercicioExistente)
            );
        });
    }

    @Override
    public void deleteById(Long idEntrenamiento, Long idEjercicio) {
        EntrenamientoEjercicioId id = new EntrenamientoEjercicioId(idEntrenamiento, idEjercicio);
        crudEntrenamientoEjercicioEntity.deleteById(id);
    }
}
