package com.backend.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ET_AuthException extends RuntimeException {
    public ET_AuthException(String msg) {
        super(msg);
    }
}