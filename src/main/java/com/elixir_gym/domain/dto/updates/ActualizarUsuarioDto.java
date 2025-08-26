package com.elixir_gym.domain.dto.updates;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ActualizarUsuarioDto(
        @NotEmpty(message = "El nombre es obligatorio")
        String nombre,

        @NotEmpty(message = "El apellido es obligatorio")
        String apellido,

        @NotEmpty(message = "El correo es obligatorio")
        String correo,

        String contrasenia,

        @NotEmpty(message = "El telefono es obligatorio")
        String telefono,

        @Past(message = "La fecha debe estar en el pasado")
        LocalDate fechaNacimiento,

        @DecimalMin(value = "30.00", message = "Peso mínimo 30kg")
        @DecimalMax(value = "300.00", message = "Peso máximo 300kg")
        BigDecimal peso,

        @DecimalMin(value = "0.50", message = "Altura mínima 0.5m")
        @DecimalMax(value = "2.50", message = "Altura máxima 2.5m")
        BigDecimal altura,

        @NotEmpty(message = "El estado es obligatorio")
        String estado
) {
}
