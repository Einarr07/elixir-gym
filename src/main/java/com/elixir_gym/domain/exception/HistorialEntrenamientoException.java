package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class HistorialEntrenamientoException extends AppException {

    public HistorialEntrenamientoException(Long idHistorial) {
        super(
                "Historial de entrenamiento no encontrado",
                "El historial con: " + idHistorial + " no existe",
                HttpStatus.NOT_FOUND
        );
    }
}
