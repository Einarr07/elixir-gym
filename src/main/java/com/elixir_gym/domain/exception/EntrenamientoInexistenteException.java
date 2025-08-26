package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class EntrenamientoInexistenteException extends AppException{

    public EntrenamientoInexistenteException(long id) {
        super(
                "Entrenamiento inexistente",
                "El entrenamiento con el id " + id + " no existe",
                HttpStatus.BAD_REQUEST
        );
    }
}
