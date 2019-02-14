package org.techolympics.web;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techolympics.domain.entity.Registration;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @GetMapping
    public List<Registration> getRegistrations() {
        return Collections.emptyList();
    }
}
