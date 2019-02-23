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
}
