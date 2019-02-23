package org.techolympics.web;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    private final RegistrationService registrationService;

    public RegistrationsController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registerStudent(@PathVariable("email") String email, @RequestBody RegisterStudentRequest request) {

        final Registration registration = new Registration();
        registration.setEmail(email);
        registration.setFirstName(request.getFirstName());
        registration.setLastName(request.getLastName());
        registration.setSchool(request.getSchool());

        registrationService.registerStudent(registration);
    }

    @GetMapping("/{email}")
    public Registration getRegistration(@PathVariable("email") String email) {
        return registrationService.getStudentRegistration(email);
    }

    @DeleteMapping("/{email}")
    public void unregisterStudent(@PathVariable("email") String email) {
        registrationService.unregisterStudent(email);
    }
}
