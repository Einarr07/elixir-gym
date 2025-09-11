package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class ReservaEntrenamientoException extends AppException{
    public ReservaEntrenamientoException(long id){
        super(
                "Reserva no encontrada",
                "La reserva con el id: " + id + " no existe",
                HttpStatus.NOT_FOUND
        );

    }
}
