package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class EntrenamientoEjercicioException extends AppException{

    public EntrenamientoEjercicioException(Long idEntrenamiento, Long idEjercicio){
        super(
                "Entrenamiento-Ejercicio no encontrado",
                "No existe la relación con idEntrenamiento: " + idEntrenamiento +
                        " e idEjercicio: " + idEjercicio,
                HttpStatus.NOT_FOUND
        );
    }
}
