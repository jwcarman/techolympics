package org.techolympics.domain.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * The <code>RegistrationService</code> is responsible for managing all student {@link Registration}s.
 */
@Validated
public interface RegistrationService {
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Returns all student registrations.
     *
     * @return all student registrations
     */
    List<Registration> getAllRegistrations();

    List<Registration> getRegistrationsBySchool(String school);

    /**
     * Returns a specific student registration by email address or throws {@link RegistrationNotFoundException} if
     * not found.
     *
     * @param email the registration email address
     * @return the student registration
     * @throws RegistrationNotFoundException if a registration matching the email address is not found
     */
    Registration getStudentRegistration(@Email String email);

    /**
     * Registers a student.
     *
     * @param registration the student registration
     */
    void registerStudent(@NotNull @Valid Registration registration);

    /**
     * Unregisters a student by email address.
     *
     * @param email the email address
     */
    void unregisterStudent(@Email String email);
}
