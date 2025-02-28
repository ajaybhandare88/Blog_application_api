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
import org.springframework.web.bind.annotation.RestController;

import com.project.api.blog.helper.CategoryDto;
import com.project.api.blog.servicesImpl.CategoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl serviceImpl;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto category=serviceImpl.save(categoryDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCatrgoryDto(@RequestBody CategoryDto categoryDto,@PathVariable("id") int id)
	{
		CategoryDto updateCategoryDto=serviceImpl.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(updateCategoryDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> findById(@PathVariable("id") int id)
	{
		CategoryDto categoryDto=serviceImpl.findById(id);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.FOUND);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> findAll()
	{
		List<CategoryDto> categoryDto=serviceImpl.findAll();
		return new ResponseEntity<List<CategoryDto>>(categoryDto,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id)
	{
		serviceImpl.delete(id);
		return new ResponseEntity<String>("Cetegory deleted successfully",HttpStatus.OK);
	}
}
