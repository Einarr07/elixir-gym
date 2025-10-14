package com.elixir_gym.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDto(
        Long idUsuario,
        String nombre,
        String apellido,
        String correo,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String contrasenia,
        String telefono,
        LocalDate fechaNacimiento,
        Double peso,
        Double altura,
        LocalDate fechaRegistro,
        String estado,
        List<RolDto> roles
) {
}
