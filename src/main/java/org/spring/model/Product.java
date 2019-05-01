package org.spring.model;

/**
 * Created by Geezy on 04.04.2019.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *  This is a data structure, so
 *  fields can be public. (Clean-Code)
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private Integer basketId;


    public Product(String name, Double price, Integer quantity, Integer basketId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.basketId = basketId;
    }
}