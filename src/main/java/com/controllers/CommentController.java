package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.service.CommentService;		

@CrossOrigin("*")
@RestController
public class CommentController {
	
	private final String URL="lmk-cm/comments"; 
	
	@Autowired
	private CommentService commentService;
	

	
	
}
