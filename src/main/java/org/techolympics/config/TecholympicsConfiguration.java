package org.techolympics.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.service.RegistrationService;

@Configuration
public class TecholympicsConfiguration {

    @Bean
    public CommandLineRunner dataLoader(RegistrationService service) {
        return args -> {
            service.registerStudent(Registration.builder()
                    .email("john@doe.com")
                    .firstName("John")
                    .lastName("Doe")
                    .school("Mason")
                    .build());
            service.registerStudent(Registration.builder()
                    .email("jane@doe.com")
                    .firstName("Jane")
                    .lastName("Doe")
                    .school("Sycamore")
                    .build());
        };
    }
}
