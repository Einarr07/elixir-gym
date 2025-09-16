package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class ClaseException extends AppException {
    public ClaseException(long id) {
        super(
                "Clase inexistente",
                "La clase con " + id + " no existe",
                HttpStatus.NOT_FOUND
        );
    }
}
