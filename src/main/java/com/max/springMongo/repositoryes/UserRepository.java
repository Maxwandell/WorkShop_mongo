package com.max.springMongo.repositoryes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.max.springMongo.Domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
