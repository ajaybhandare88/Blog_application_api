package com.project.api.blog.services;

import java.util.List;

import com.project.api.blog.entity.Post;
import com.project.api.blog.helper.PaginationDetails;
import com.project.api.blog.helper.PostDto;

public interface PostServices {

	public PostDto createPost(Post post,int categoryId,int userId);
	public PostDto updatePost(PostDto postDto,int id);
	public PostDto findById(int id);
	public PaginationDetails findAll(int pageNumber,int pageSize);
	public void deleteById(int id);
	
	public List<PostDto> findByUserId(int userId);
	public List<PostDto> findByCategoryId(int id);
	public List<PostDto> findByUserIdAndCategoryId(int userId,int categoryId);
	public List<PostDto> searchByTitle(String title);
	
	
	
}
