package org.techolympics.domain.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;
import org.techolympics.domain.repository.RegistrationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Optional.ofNullable;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository repository;


    public RegistrationServiceImpl(RegistrationRepository repository) {
        this.repository = repository;
    }

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
        if(!repository.existsById(email)) {
            throw new RegistrationNotFoundException(email);
        }
        repository.deleteById(email);
    }

    @Override
    public List<Registration> getRegistrationsBySchool(String school) {
        return Lists.newArrayList(repository.findBySchool(school));
    }
}
