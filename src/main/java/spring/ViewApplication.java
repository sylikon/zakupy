package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.model.ProductRepository;

import javax.sql.DataSource;

/**
 * Created by Geezy on 04.04.2019.
 */
@SpringBootApplication

public class ViewApplication {


    @Autowired
    DataSource dataSource;


    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
         SpringApplication.run(ViewApplication.class, args);
    }

}
