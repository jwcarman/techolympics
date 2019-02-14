package org.techolympics.domain.service;

import java.util.List;

import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;

/**
 * The <code>RegistrationService</code> is responsible for managing all student {@link Registration}s.
 */
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

    /**
     * Returns a specific student registration by email address or throws {@link RegistrationNotFoundException} if
     * not found.
     *
     * @param email the registration email address
     * @return the student registration
     * @throws RegistrationNotFoundException if a registration matching the email address is not found
     */
    Registration getStudentRegistration(String email);

    /**
     * Registers a student.
     *
     * @param registration the student registration
     */
    void registerStudent(Registration registration);

    /**
     * Unregisters a student by email address.
     *
     * @param email the email address
     */
    void unregisterStudent(String email);
}
