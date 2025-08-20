package com.elixir_gym.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDto(
        Long idUsuario,
        String nombre,
        String apellido,
        String correo,
        String contrasenia,
        String telefono,
        LocalDate fechaNacimiento,
        Double peso,
        Double altura,
        LocalDate fechaRegistro,
        String estado,
        List<RolDto> roles
) {
}
