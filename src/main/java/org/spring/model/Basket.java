package org.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Geezy on 09.04.2019.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String basketName;
    private Integer userId;

    public Basket(String basketName, Integer userId){
        this.basketName = basketName;
        this.userId=userId;
    }


}
