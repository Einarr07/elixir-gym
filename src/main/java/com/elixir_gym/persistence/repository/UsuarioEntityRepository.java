package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.updates.ActualizarUsuarioDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.repository.IUsuarioRepository;
import com.elixir_gym.persistence.crud.ICrudUsuarioEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import com.elixir_gym.persistence.mapper.IUsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UsuarioEntityRepository implements IUsuarioRepository {

    private final ICrudUsuarioEntity crudUsuarioEntity;
    private final IUsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDto> findAll() {
        return usuarioMapper.toDtoList(crudUsuarioEntity.findAll());
    }

    @Override
    public Optional<UsuarioDto> findById(long id) {
        return crudUsuarioEntity.findById(id).map(usuarioMapper::toDto);
    }

    @Override
    public Optional<UsuarioDto> findByEmail(String correo) {
        return Optional.ofNullable(usuarioMapper.toDto(crudUsuarioEntity.findByEmail(correo)));
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioDto);
        return usuarioMapper.toDto(crudUsuarioEntity.save(usuarioEntity));
    }

    @Override
    public Optional<UsuarioDto> update(long id, ActualizarUsuarioDto usuarioDto) {

        return crudUsuarioEntity.findById(id).map(usuarioExistente -> {
            usuarioMapper.updateUsuario(usuarioDto, usuarioExistente);
            return usuarioMapper.toDto(crudUsuarioEntity.save(usuarioExistente));
        });
    }

    @Override
    public void deleteById(long id) {
        crudUsuarioEntity.deleteById(id);
    }
}
