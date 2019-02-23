package org.techolympics.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.techolympics.domain.exception.RegistrationNotFoundException;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(RegistrationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onRegistrationNotFound(RegistrationNotFoundException e) {
        return e.getMessage();
    }
}
