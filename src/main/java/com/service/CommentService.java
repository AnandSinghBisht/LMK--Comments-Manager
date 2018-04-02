package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Comment;
import com.models.QuestionComments;
import com.models.Response;
import com.repository.CommentRepository;
import com.repository.QuestionCommentsRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private QuestionCommentsRepository questionCommentRepo;
	
	public QuestionComments getQuestionComment(String questionId) {

		Optional<QuestionComments> optionalQuestionComments = questionCommentRepo.findById(questionId);
		return optionalQuestionComments.isPresent() ? optionalQuestionComments.get() : null;
	}
	
	public Comment getComment(String id){
		
		Optional<Comment> optionalcomments = commentRepo.findById(id);
		return optionalcomments.isPresent() ? optionalcomments.get() : null;
	}

	public Response updateComment(Comment comment) {
		try{
			commentRepo.save(comment);
			
		}catch (Exception e) {
			e.printStackTrace();
			return Response.ERROR;
		}
		return Response.SUCCESS;
	}

	public Response deleteComment(String id) {
		try {
			commentRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ERROR;
		}
		return Response.SUCCESS;
	}
	
	
	
}
