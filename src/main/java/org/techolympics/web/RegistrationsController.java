package org.techolympics.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final RegistrationService registrationService;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public RegistrationsController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegistration(@PathVariable(value = "email") String email) {
        registrationService.unregisterStudent(email);
    }

    @GetMapping("/{email}")
    public Registration getRegistration(@PathVariable(value = "email") String email) {
        return registrationService.getStudentRegistration(email);
    }

    @GetMapping
    public List<Registration> getRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putRegistration(@PathVariable(value = "email") String email, @RequestBody PutRegistrationRequest request) {
        registrationService.registerStudent(Registration.builder()
                .email(email)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .school(request.getSchool())
                .build());
    }
}
