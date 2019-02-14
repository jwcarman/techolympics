package org.techolympics.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;

import static java.util.Optional.ofNullable;

public class RegistrationServiceImpl implements RegistrationService {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final Map<String, Registration> registrations = new ConcurrentHashMap<>();

//----------------------------------------------------------------------------------------------------------------------
// RegistrationService Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public List<Registration> getAllRegistrations() {
        return new ArrayList<>(registrations.values());
    }

    @Override
    public Registration getStudentRegistration(String email) {
        return ofNullable(registrations.get(email)).orElseThrow(() -> new RegistrationNotFoundException(email));
    }

    @Override
    public void registerStudent(Registration registration) {
        registrations.put(registration.getEmail(), registration);
    }

    @Override
    public void unregisterStudent(String email) {
        registrations.remove(email);
    }
}
