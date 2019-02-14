package org.techolympics.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
