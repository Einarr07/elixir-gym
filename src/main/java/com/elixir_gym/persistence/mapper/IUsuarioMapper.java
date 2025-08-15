package com.elixir_gym.persistence.mapper;

import com.elixir_gym.domain.dto.ActualizarUsuarioDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "password", target = "contrasenia")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    @Mapping(source = "estado", target = "estado")
    UsuarioDto toDto(UsuarioEntity usuarioEntity);
    List<UsuarioDto> toDtoList(Iterable<UsuarioEntity> usuarioEntityIterable);

    @InheritInverseConfiguration
    UsuarioEntity toEntity(UsuarioDto usuarioDto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "contrasenia", target = "password")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "estado", target = "estado")
    void updateUsuario(ActualizarUsuarioDto usuarioDto, @MappingTarget UsuarioEntity usuarioEntity);
}
