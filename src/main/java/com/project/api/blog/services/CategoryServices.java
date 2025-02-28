package com.project.api.blog.services;

import java.util.*;
import com.project.api.blog.helper.CategoryDto;

public interface CategoryServices {
	
	public CategoryDto save(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto,int id);

	public CategoryDto findById(int id);
	
	public List<CategoryDto> findAll();
	
	public void delete(Integer id);

}
