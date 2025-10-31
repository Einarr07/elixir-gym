package com.elixir_gym.web.exception;

import com.elixir_gym.domain.exception.AppException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManejadorExceptionRest {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerExceptionActualizacion(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Error> handlerAppException(AppException ex) {
        Error error = new Error(ex.getType(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Crea un objeto Error consistente con tus otros manejadores
        Error error = new Error(
                "DataIntegrityViolation", // Un tipo claro para el error
                "No se puede borrar el entrenamiento porque tiene ejercicios asignados." // Tu mensaje personalizado
        );

        // Retorna una respuesta con el código 409 (Conflict) y el cuerpo del error
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
