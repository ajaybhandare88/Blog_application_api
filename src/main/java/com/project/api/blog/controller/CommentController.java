package com.project.api.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.blog.entity.Comment;
import com.project.api.blog.helper.ApiExceptions;
import com.project.api.blog.helper.CommentDto;
import com.project.api.blog.servicesImpl.CommentServiceImpl;


@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentServiceImpl commentServiceImpl;
	
	@PostMapping("/user/{userId}/post/{postId}/comment")
	public ResponseEntity<CommentDto> create(@RequestBody Comment comment,@PathVariable("userId")int userId,@PathVariable("postId")int postId)
	{
		return new ResponseEntity<CommentDto>(commentServiceImpl.createComment(comment,userId,postId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiExceptions> delete(@PathVariable("id") int id)
	{
		commentServiceImpl.deleteComment(id);
		ApiExceptions e=new ApiExceptions();
		e.setMessage("Comment delete successfully");
		e.setResult(true);
		return new ResponseEntity<ApiExceptions>(e,HttpStatus.OK);
	}
	
}
