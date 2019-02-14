package org.techolympics.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.exception.RegistrationNotFoundException;
import org.techolympics.domain.service.RegistrationServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RegistrationServiceImplTest {
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    @Test
    void shouldRegister() {
        final RegistrationServiceImpl service = new RegistrationServiceImpl();

        final Registration expected = Registration.builder()
                .email("john@doe.com")
                .firstName("Joe")
                .lastName("Doe")
                .school("Mason")
                .build();
        service.registerStudent(expected);


        final Registration actual = service.getStudentRegistration("john@doe.com");
        assertThat(actual)
                .isNotNull()
                .isEqualTo(expected);
    }

    @Test
    void shouldReturnAll() {
        final RegistrationServiceImpl service = new RegistrationServiceImpl();
        final Registration johnDoe = Registration.builder()
                .email("john@doe.com")
                .firstName("Joe")
                .lastName("Doe")
                .school("Mason")
                .build();
        final Registration janeDoe = Registration.builder()
                .email("jane@doe.com")
                .firstName("Jane")
                .lastName("Doe")
                .school("Sycamore")
                .build();

        service.registerStudent(johnDoe);
        service.registerStudent(janeDoe);

        final List<Registration> actual = service.getAllRegistrations();

        assertThat(actual)
                .isNotNull()
                .hasSize(2)
                .contains(johnDoe)
                .contains(janeDoe);
    }

    @Test
    void shouldUnregister() {
        final RegistrationServiceImpl service = new RegistrationServiceImpl();

        service.registerStudent(Registration.builder()
                .email("john@doe.com")
                .firstName("Joe")
                .lastName("Doe")
                .school("Mason")
                .build());

        service.unregisterStudent("john@doe.com");

        assertThatThrownBy(() -> service.getStudentRegistration("john@doe.com"))
                .isExactlyInstanceOf(RegistrationNotFoundException.class)
                .hasMessage("Registration for email \"john@doe.com\" not found.");
    }
}