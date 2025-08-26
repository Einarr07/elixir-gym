package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class EjercicioInexistenteException extends AppException {

    public EjercicioInexistenteException(long id) {
        super(
                "Ejercicio inexistente",
                "El ejercicio con id " + id + " no existe",
                HttpStatus.BAD_REQUEST);
    }
}
