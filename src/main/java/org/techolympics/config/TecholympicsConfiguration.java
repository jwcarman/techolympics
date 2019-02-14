package org.techolympics.config;

import org.springframework.boot.CommandLineRunner;
import org.techolympics.domain.service.RegistrationService;

public class TecholympicsConfiguration {

    public CommandLineRunner dataLoader(RegistrationService service) {
        return args -> {

        };
    }
}
