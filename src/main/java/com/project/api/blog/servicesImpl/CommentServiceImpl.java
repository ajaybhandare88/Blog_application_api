package com.project.api.blog.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.blog.dao.CommentRepo;
import com.project.api.blog.dao.PostRepo;
import com.project.api.blog.dao.UserRepo;
import com.project.api.blog.entity.Comment;
import com.project.api.blog.entity.Post;
import com.project.api.blog.entity.User;
import com.project.api.blog.exceptions.ResourceNotFound;
import com.project.api.blog.helper.CommentDto;
import com.project.api.blog.services.CommentServices;

@Service
public class CommentServiceImpl implements CommentServices{

	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CommentDto createComment(Comment comment,int userId,int postId) {
		
		User user=userRepo.findById(userId);
		if(user==null)
		{
			throw new ResourceNotFound("User", "id", userId);
		}
		
		Post post=postRepo.findById(postId);
		if(post==null)
		{
			throw new ResourceNotFound("Comment", "id", postId);
		}
		
		comment.setUser(user);
		comment.setPost(post);
		
		Comment savedComment=commentRepo.save(comment);
		return mapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(int id) {
		
		Comment findComment=commentRepo.findById(id);
		if(findComment==null)
		{
			throw new ResourceNotFound("Comment", "id", id);
		}
		
		commentRepo.delete(findComment);
	}

}
