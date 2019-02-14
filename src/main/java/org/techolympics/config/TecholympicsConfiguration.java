package org.techolympics.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.techolympics.domain.service.RegistrationService;

@Configuration
public class TecholympicsConfiguration {

    public CommandLineRunner dataLoader(RegistrationService service) {
        return args -> {

        };
    }
}
