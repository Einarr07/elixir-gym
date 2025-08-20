package com.elixir_gym.web.exception;

import com.elixir_gym.domain.exception.CorreoRegistradoException;
import com.elixir_gym.domain.exception.RolInexistenteException;
import com.elixir_gym.domain.exception.UsuarioInexistenteException;
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

    @ExceptionHandler(CorreoRegistradoException.class)
    public ResponseEntity<Error> handlerExceptionCorreo(CorreoRegistradoException ex) {
        Error error = new Error("El correo ya se encuentra registrado", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioInexistenteException.class)
    public ResponseEntity<Error> handlerExceptionUsuarioInexistente(UsuarioInexistenteException ex) {
        Error error = new Error("Usuario inexistente", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RolInexistenteException.class)
    public ResponseEntity<Error> handlerExceptionRolInexistente(RolInexistenteException ex) {
        Error error = new Error("Rol inexistente", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
