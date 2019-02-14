package org.techolympics.domain.exception;

public class RegistrationNotFoundException extends RuntimeException {
//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public RegistrationNotFoundException(String email) {
        super(String.format("Registration for email \"%s\" not found.", email));
    }
}
