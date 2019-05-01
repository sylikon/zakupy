package org.spring.controller;

import org.spring.model.User;
import org.spring.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Geezy on 09.04.2019.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces={"application/json"}, consumes="application/json")
    public ResponseEntity addUser(
            @RequestBody User user
    ) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET,
            produces={"application/json"})
    public List<User> getUser(
    ) {
        return (List<User>) userRepository.findAll();
    }
}
