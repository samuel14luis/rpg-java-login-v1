package com.bootcamp.login.repository;

import org.springframework.boot.provided.login.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, Long> {

}
