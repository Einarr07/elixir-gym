package com.elixir_gym.domain.exception;

public class UsuarioInexistenteException extends RuntimeException{

    public UsuarioInexistenteException(long id) {
        super("El usuario con el ID: " + id + " no existe");
    }
}
