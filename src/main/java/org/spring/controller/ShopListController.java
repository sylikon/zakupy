package org.spring.controller;

import org.spring.model.Product;
import org.spring.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Geezy on 04.04.2019.
 */
@RestController
public class ShopListController {


    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/zakupy", method = RequestMethod.POST,
            produces={"application/json","application/xml"}, consumes="application/json")
    public ResponseEntity addZakupy(
            @RequestBody Product product
    ) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/getAllZakupy", method = RequestMethod.GET)
    public List<Product>  get(
    ) {
        return (List<Product>) productRepository.findAll();
    }

}
