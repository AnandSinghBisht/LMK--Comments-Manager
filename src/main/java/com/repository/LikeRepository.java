package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Like;

public interface LikeRepository extends MongoRepository<Like, String> {

}
