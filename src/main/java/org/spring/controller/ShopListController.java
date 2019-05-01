package org.spring.controller;

import org.spring.model.Basket;
import org.spring.model.BasketRepository;
import org.spring.model.Product;
import org.spring.model.ProductRepository;
import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Geezy on 04.04.2019.
 */
@RestController
@RequestMapping("shop")
public class ShopListController {


    private ProductRepository productRepository;
    private BasketRepository basketRepository;
    private ShopService shopService;

    @Autowired
    public ShopListController(ProductRepository productRepository, BasketRepository basketRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
        this.shopService = shopService;
    }

    @RequestMapping(value = "/zakupy", method = RequestMethod.POST,
            produces = {"application/json", "application/xml"}, consumes = "application/json")
    public ResponseEntity addZakupy(
            @RequestBody Product product
    ) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/getAllZakupy", method = RequestMethod.GET)
    public List<Product> get(
    ) {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value = "/getAllBasket", method = RequestMethod.GET)
    public List<Basket> getBaket(
    ) {
        return (List<Basket>) basketRepository.findAll();
    }

    @RequestMapping(value = "/createBasket", method = RequestMethod.POST,
            produces = {"application/json"}, consumes = "application/json")
    public ResponseEntity createBasket(
            @RequestBody Basket basket
    ) {
        basketRepository.save(basket);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{basketId}/getProductsFromBasket", method = RequestMethod.GET,
            produces = {"application/json"})
    public ResponseEntity createBasket(
            @PathVariable("basketId") Integer basketId
    ) {
        return ResponseEntity.ok(shopService.getAllProductsFromBasket(basketId));
    }

}
