package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.QuestionComments;

public interface QuestionCommentsRepository extends MongoRepository<QuestionComments, String> {

}
