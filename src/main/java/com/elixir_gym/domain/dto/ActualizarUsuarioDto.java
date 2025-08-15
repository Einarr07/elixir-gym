package com.elixir_gym.domain.dto;

import java.time.LocalDate;

public record ActualizarUsuarioDto(
        String nombre,
        String apellido,
        String correo,
        String contrasenia,
        String telefono,
        LocalDate fechaNacimiento,
        Double peso,
        Double altura,
        Boolean estado
) {
}
