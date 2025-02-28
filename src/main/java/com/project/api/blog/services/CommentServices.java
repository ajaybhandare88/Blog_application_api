package com.project.api.blog.services;

import com.project.api.blog.entity.Comment;
import com.project.api.blog.helper.CommentDto;

public interface CommentServices {

	public CommentDto createComment(Comment comment,int userId,int postId);
	public void deleteComment(int id);
	
}
