package org.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Geezy on 04.04.2019.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
