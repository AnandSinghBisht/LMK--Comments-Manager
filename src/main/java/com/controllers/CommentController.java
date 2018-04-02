package com.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Comment;
import com.models.QuestionComments;
import com.models.Response;
import com.service.CommentService;		

@CrossOrigin("*")
@RestController
public class CommentController {
	
	private final String BASE_URL="lmk-cm/"; 
	
	//XSS must be implemented for all getters
	
	//all method except get must check proper authenticatio and authorisation first
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * get All comments for a question/ post
	 * @param questionId
	 * @return QuestionComments
	 */
	@RequestMapping(name=BASE_URL+"/comments/{questionId}/", method=RequestMethod.GET)
	public QuestionComments getComments(@PathParam("questionId")String questionId) {
		System.out.println("Inside getComments, questionId: "+ questionId);
		return commentService.getQuestionComment(questionId);
	}
	
	/**
	 * get Comment by Id
	 * @param Comment Id
	 * @return Comment
	 */
/*	@RequestMapping(name=BASE_URL+"{id}/", method=RequestMethod.GET)
	public Comment getComment(@PathParam("id")String id) {
		System.out.println("Inside getComment, Id: "+ id);
		return commentService.getComment(id);
	}*/

	/**
	 * create or update comment
	 * @param comment
	 * @return sucess or error
	 */
	@RequestMapping(name=BASE_URL, method=RequestMethod.POST)
	public Response updateComment(@RequestBody Comment comment) {
		System.out.println("Inside Update Comment, Comment: "+ comment);
		return commentService.updateComment(comment);
	}
	
	/**
	 * Delete comment by Id
	 * @param id
	 * @return
	 */
	@RequestMapping(name=BASE_URL+"{id}", method=RequestMethod.DELETE)
	public Response deleteComment(String id) {
		System.out.println("Inside deleteComment, Id: "+ id);
		return commentService.deleteComment(id);
	}
	
	
	/**
	 * just to add some dummy qustion will be removed in future
	 */
	@RequestMapping(value=BASE_URL+"/saveDummy" ,method=RequestMethod.POST)
	public void addComments()
	{
		System.out.println("We are here");
		Comment q=new Comment();
		q.setId("C-1");
		q.setQuestionId("Q-1");
		q.setText("FirstComment on question 1");
		commentService.updateComment(q);
		
		q=new Comment();
		q.setQuestionId("Q-1");
		q.setId("C-2");
		q.setText("2nd Comment on question 1");
		commentService.updateComment(q);
		
		q=new Comment();
		q.setQuestionId("Q-1");
		q.setId("C-3");
		q.setText("3rd Comment on question 1");
		commentService.updateComment(q);
		
		q=new Comment();
		q.setQuestionId("Q-1");
		q.setId("C-4");
		q.setText("4th Comment on question 1");
		commentService.updateComment(q);
		
		q=new Comment();
		q.setQuestionId("Q-1");
		q.setId("C-5");
		q.setText("5th Comment on question 1");
		commentService.updateComment(q);
		

		q=new Comment();
		q.setQuestionId("Q-2");
		q.setId("C-6");
		q.setText("FirstComment on question 2");
		commentService.updateComment(q);
		
		q=new Comment();
		q.setQuestionId("Q-3");
		q.setId("C-7");
		q.setText("FirstComment on question 3");
		commentService.updateComment(q);
		
		System.out.println("All set..");
	}
	
	
}
