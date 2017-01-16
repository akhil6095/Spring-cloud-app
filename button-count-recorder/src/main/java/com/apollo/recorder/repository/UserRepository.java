package com.apollo.recorder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apollo.recorder.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserName(String userName);

}
