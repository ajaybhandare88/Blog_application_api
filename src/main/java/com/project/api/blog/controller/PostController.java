package com.project.api.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.blog.entity.Post;
import com.project.api.blog.helper.ApiExceptions;
import com.project.api.blog.helper.PaginationDetails;
import com.project.api.blog.helper.PostDto;
import com.project.api.blog.servicesImpl.PostServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	PostServicesImpl postServicesImpl;
	
	@PostMapping("/{userid}/{categoryId}")
	public ResponseEntity<PostDto> save(@Valid @RequestBody Post postDto,@PathVariable int userid,@PathVariable int categoryId)
	{
		return new ResponseEntity<PostDto>(postServicesImpl.createPost(postDto,categoryId,userid),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable int id)
	{
		return new ResponseEntity<PostDto>(postServicesImpl.updatePost(postDto, id),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> findPostById(@PathVariable int id)
	{
		return new ResponseEntity<PostDto>(postServicesImpl.findById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/page")
	public ResponseEntity<PaginationDetails> findAllPost(@RequestParam(value="pageNumber",defaultValue = "0",required = false)int pageNumber,@RequestParam(value ="pageSize",defaultValue = "3",required = false)int pageSize)
	{
		return new ResponseEntity<PaginationDetails>(postServicesImpl.findAll(pageNumber,pageSize),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiExceptions> deletePost(@PathVariable int id)
	{
		postServicesImpl.deleteById(id);
		ApiExceptions ex=new ApiExceptions();
		ex.setMessage("Post Delete Successfully");
		ex.setResult(true);
		return new ResponseEntity<ApiExceptions>(ex,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/post")
	public ResponseEntity<List<PostDto>> findPostByUserId(@PathVariable int id)
	{
		return new ResponseEntity<List<PostDto>>(postServicesImpl.findByUserId(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/category/{id}/post")
	public ResponseEntity<List<PostDto>> findPostByCategoryId(@PathVariable int id)
	{
		return new ResponseEntity<List<PostDto>>(postServicesImpl.findByCategoryId(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<List<PostDto>> findPostByUserIdAndCategoryId(@PathVariable int userId,@PathVariable int categoryId)
	{
		return new ResponseEntity<List<PostDto>>(postServicesImpl.findByUserIdAndCategoryId(userId, categoryId),HttpStatus.FOUND);
	}
	
	@GetMapping("/search/{string}")
	public ResponseEntity<List<PostDto>> findPostByUserIdAndCategoryId(@PathVariable String string)
	{
		return new ResponseEntity<List<PostDto>>(postServicesImpl.searchByTitle(string),HttpStatus.FOUND);
	}

}
