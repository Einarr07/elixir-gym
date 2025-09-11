package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class NivelEntrenamientoException extends AppException {

    public NivelEntrenamientoException(List<String> niveles) {
        super(
                "Nivel de entrenamiento incorrecto",
                "Los niveles de entrenamiento validos son: " + String.join(", ", niveles),
                HttpStatus.BAD_REQUEST
        );
    }
}
