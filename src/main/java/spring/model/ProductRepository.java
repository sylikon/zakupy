package spring.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Geezy on 04.04.2019.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * spring-jpa-data understands this method name,
     * because it supports the resolution of specific keywords inside method names.
     **/
    List<Product> findByNameContainingIgnoreCase(String searchString);

    /**
     * You can define a JPA query.
     **/
    @Query("select p from Product p where p.name = :name")
    List<Product> findByNameIs(@Param("name") String name);

}
