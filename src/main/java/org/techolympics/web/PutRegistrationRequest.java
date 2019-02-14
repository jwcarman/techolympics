package org.techolympics.web;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PutRegistrationRequest {
    private String firstName;

    private String lastName;

    private String school;
}
