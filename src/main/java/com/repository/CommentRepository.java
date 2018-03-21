package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{
	
}
