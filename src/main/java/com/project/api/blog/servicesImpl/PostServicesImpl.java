package com.project.api.blog.servicesImpl;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.api.blog.dao.CategoryRepo;
import com.project.api.blog.dao.PostRepo;
import com.project.api.blog.dao.UserRepo;
import com.project.api.blog.entity.Category;
import com.project.api.blog.entity.Post;
import com.project.api.blog.entity.User;
import com.project.api.blog.exceptions.ResourceNotFound;
import com.project.api.blog.helper.PaginationDetails;
import com.project.api.blog.helper.PostDto;
import com.project.api.blog.services.PostServices;

@Service
public class PostServicesImpl implements PostServices{
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public PostDto createPost(Post post,int categoryId,int userId) {
		
		User user=userRepo.findById(userId);
		Category category=categoryRepo.findById(categoryId);
		
		if(user==null)
		{
			throw new ResourceNotFound("User", "id", userId);
		}
		if(category==null)
		{
			throw new ResourceNotFound("Category", "id", userId);
		}
		
		post.setUser(user);
		post.setCategory(category);
		post.setAddedDate(new Date());
		post.setImageName("Defult.jpeg");
		
		Post savedPost=postRepo.save(post);
		return mapper.map(savedPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, int id) {
		Post post=postRepo.findById(id);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setAddedDate(postDto.getAddedDate());
		post.setImageName(post.getImageName());
		post.setCategory(post.getCategory());
		post.setUser(mapper.map(postDto.getUser(), User.class));
		return mapper.map(postRepo.save(post),PostDto.class);
	}

	@Override
	public PostDto findById(int id) {
		Post post=postRepo.findById(id);
		if(post==null)
		{
			throw new ResourceNotFound("Post", "id", id);
		}
		return mapper.map(post,PostDto.class);
	}

	@Override
	public PaginationDetails findAll(int pageNumber,int pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Post> pageList=postRepo.findAll(p);
		List<Post> postList=pageList.getContent();
		
		List<PostDto> postDtoList=new ArrayList<PostDto>();
		postList.forEach((post)->{
			postDtoList.add(mapper.map(post, PostDto.class));
		});
		
		PaginationDetails paginationDetails=new PaginationDetails();
		paginationDetails.setListOfPostDto(postDtoList);
		paginationDetails.setCurrentPageNumber(pageList.getNumber());
		paginationDetails.setTotalPageNumber(pageList.getTotalPages());
		paginationDetails.setPageDataValue(pageList.getSize());
		paginationDetails.setLast(pageList.isLast());
		return paginationDetails;
	}

	@Override
	public void deleteById(int id) {
		Post post=postRepo.findById(id);
		if(post==null)
		{
			throw new ResourceNotFound("Post", "id", id);
		}
		postRepo.delete(post);
	}

	@Override
	public List<PostDto> findByUserId(int id) {
		List<Post> postList=postRepo.findByUserId(id);
		List<PostDto> postDtoList=new ArrayList<PostDto>();
		postList.forEach((post)->{
			postDtoList.add(mapper.map(post, PostDto.class));
		});
		
		
		
		return postDtoList;
	}

	@Override
	public List<PostDto> findByCategoryId(int id) {
		List<Post> postList=postRepo.findByCategoryId(id);
		List<PostDto> postDtoList=new ArrayList<PostDto>();
		postList.forEach((post)->{
			postDtoList.add(mapper.map(post, PostDto.class));
		});
		return postDtoList;
	}

	@Override
	public List<PostDto> findByUserIdAndCategoryId(int userId, int categoryId) {
		List<Post> postList=postRepo.findByUserIdAndCategoryId(userId, categoryId);
		List<PostDto> postDtoList=new ArrayList<PostDto>();
		postList.forEach((post)->{
			postDtoList.add(mapper.map(post, PostDto.class));
		});
		return postDtoList;
	}

	@Override
	public List<PostDto> searchByTitle(String title) {
		List<Post> searchList=postRepo.searchByTitle("%"+title+"%");
		
		List<PostDto> postDtoList=new ArrayList<PostDto>();
		searchList.forEach((post)->{
			postDtoList.add(mapper.map(post, PostDto.class));
		});
		return postDtoList;
	}

}
