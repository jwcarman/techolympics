package org.techolympics.domain.service;

import java.util.List;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;
import org.techolympics.domain.repository.RegistrationRepository;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final RegistrationRepository repository;

//----------------------------------------------------------------------------------------------------------------------
// RegistrationService Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public List<Registration> getAllRegistrations() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Registration getStudentRegistration(String email) {
        return repository.findById(email).orElseThrow(() -> new RegistrationNotFoundException(email));
    }

    @Override
    public void registerStudent(Registration registration) {
        repository.save(registration);
    }

    @Override
    public void unregisterStudent(String email) {
        repository.deleteById(email);
    }
}
