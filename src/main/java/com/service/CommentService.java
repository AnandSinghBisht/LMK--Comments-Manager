package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Comment;
import com.models.QuestionComments;
import com.repository.CommentRepository;
import com.repository.QuestionCommentsRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private QuestionCommentsRepository questionCommentRepo;
	
	public QuestionComments getQuestionComment(String id) {

		Optional<QuestionComments> optionalQuestionComments = questionCommentRepo.findById(id);
		return optionalQuestionComments.isPresent() ? optionalQuestionComments.get() : null;
	}
	
	public Comment getComment(String id){
		
		Optional<Comment> optionalcomments = commentRepo.findById(id);
		return optionalcomments.isPresent() ? optionalcomments.get() : null;
	}
	
	//getQestions by list of Ids or get multiple quetion by single field
	
	
}
