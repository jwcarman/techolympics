package org.techolympics.web;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.techolympics.domain.entity.Registration;
import org.techolympics.domain.service.RegistrationService;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RegistrationsController.class)
class RegistrationsControllerTest {

    @MockBean
    private RegistrationService registrationService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnRegistrationsFromService() throws Exception {
        when(registrationService.getAllRegistrations()).thenReturn(Lists.newArrayList(
                Registration.builder()
                        .email("john@doe.com")
                        .firstName("Joe")
                        .lastName("Doe")
                        .school("Mason")
                        .build(),
                Registration.builder()
                        .email("jane@doe.com")
                        .firstName("Jane")
                        .lastName("Doe")
                        .school("Sycamore")
                        .build()
        ));
        mvc.perform(get("/registrations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}