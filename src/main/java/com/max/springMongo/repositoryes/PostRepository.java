package com.max.springMongo.repositoryes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.max.springMongo.Domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
