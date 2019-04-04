package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Product;
import spring.service.ProductService;

/**
 * Created by Geezy on 04.04.2019.
 */
@RestController
public class ShopListController {


    @Autowired
    private ProductService productRepository;

    @RequestMapping(value = "/zakupy", method = RequestMethod.POST)
    public ResponseEntity addZakupy(
            @RequestBody Product product
    ) {
        productRepository.add(product);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/getAllZakupy", method = RequestMethod.GET)
    public String get(
    ) {
        return "test";
    }

}
