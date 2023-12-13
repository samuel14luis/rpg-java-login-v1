package com.bootcamp.login.controllers;

import com.bootcamp.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.provided.login.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Mono<?> createUser(@RequestBody User user) {
        return userRepository.save(user)
                .map(u -> ResponseEntity.ok().body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
