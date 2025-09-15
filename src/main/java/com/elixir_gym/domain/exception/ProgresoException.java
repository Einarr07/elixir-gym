package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class ProgresoException extends AppException {
    public ProgresoException(long id) {
        super(
                "Progreso inexistente",
                "El progreso con id " + id + " no existe",
                HttpStatus.NOT_FOUND
        );
    }
}
