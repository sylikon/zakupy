package org.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Geezy on 09.04.2019.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
