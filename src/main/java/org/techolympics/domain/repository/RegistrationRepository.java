package org.techolympics.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.techolympics.domain.entity.Registration;

public interface RegistrationRepository extends CrudRepository<Registration,String> {
}
