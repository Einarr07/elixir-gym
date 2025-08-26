package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class GrupoMuscularInexistenteException extends AppException {

    public GrupoMuscularInexistenteException(long id) {
        super(
                "Grupo muscular inexistente",
                "El grupo muscular con id " + id + " no existe",
                HttpStatus.BAD_REQUEST
        );
    }
}
