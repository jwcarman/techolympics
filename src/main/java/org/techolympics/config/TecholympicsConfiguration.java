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
            final Registration johnDoe = new Registration();
            johnDoe.setEmail("john@doe.com");
            johnDoe.setFirstName("Joe");
            johnDoe.setLastName("Doe");
            johnDoe.setSchool("Mason");

            service.registerStudent(johnDoe);

            final Registration janeDoe = new Registration();
            janeDoe.setEmail("jane@doe.com");
            janeDoe.setFirstName("Jane");
            janeDoe.setLastName("Doe");
            janeDoe.setSchool("Sycamore");

            service.registerStudent(janeDoe);
        };
    }
}
