package com.project.api.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
	public Comment findById(int id);
	
}
