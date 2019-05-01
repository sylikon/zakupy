package org.spring.service;

import org.spring.model.BasketRepository;
import org.spring.model.Product;
import org.spring.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geezy on 09.04.2019.
 */
@Service
public class ShopService {

    private BasketRepository basketRepository;
    private ProductRepository productRepository;

    @Autowired
    public ShopService(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }


    public List<Product> getAllProductsFromBasket(Integer basketId) {
        List<Product> productList = new ArrayList<Product>();
        for (Product product : productRepository.findAll()) {
            if (product.getBasketId() != null) {
                if (product.getBasketId().equals(basketId)) {
                    productList.add(product);
                }
            }
        }
        return productList;
    }

}
