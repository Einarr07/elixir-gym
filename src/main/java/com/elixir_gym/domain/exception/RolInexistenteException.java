package com.elixir_gym.domain.exception;

public class RolInexistenteException extends RuntimeException {

    public RolInexistenteException(long id) {
        super("El rol con el ID: " + id + " no existe");
    }
}
