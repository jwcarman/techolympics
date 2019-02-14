package org.techolympics.web.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.techolympics.domain.exception.RegistrationNotFoundException;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(RegistrationNotFoundException.class)
    public String onRegistrationNotFound(RegistrationNotFoundException e) {
        return e.getMessage();
    }
}
