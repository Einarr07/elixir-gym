package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class HorarioClaseException extends AppException {

    public HorarioClaseException(long id) {
        super(
                "El horario de clase no existe",
                "El horario de clase con id: " + id + " no existe",
                HttpStatus.NOT_FOUND
        );
    }

}
