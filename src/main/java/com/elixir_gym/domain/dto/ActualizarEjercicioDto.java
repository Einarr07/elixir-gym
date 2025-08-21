package com.elixir_gym.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ActualizarEjercicioDto(
        @NotEmpty(message = "El nombre es obligatorio")
        String nombre,

        @NotEmpty(message = "Debe existir una descripcion")
        String descripcion,

        String video,

        String imagen,

        @NotEmpty(message = "Se debe agregar el equipo necesario para el ejercicio")
        String equipo_necesario,

        @NotNull(message = "El grupo muscular es obligatorio")
        GrupoMuscularDto grupo_muscular
) {
}
