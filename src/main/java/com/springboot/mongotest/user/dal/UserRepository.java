package com.springboot.mongotest.user.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongotest.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
