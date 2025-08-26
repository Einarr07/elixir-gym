package com.elixir_gym.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AppException extends RuntimeException {

    private final String type;

    private final HttpStatus status;

    protected AppException(String type, String message,HttpStatus status) {
        super(message);
        this.type = type;
        this.status = status;
    }

}
