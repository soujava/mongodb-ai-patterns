package org.soujava.samples.ai.patterns.planning;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
