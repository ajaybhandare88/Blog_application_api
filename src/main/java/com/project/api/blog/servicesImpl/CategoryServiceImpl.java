package com.project.api.blog.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.blog.dao.CategoryRepo;
import com.project.api.blog.entity.Category;
import com.project.api.blog.exceptions.ResourceNotFound;
import com.project.api.blog.helper.CategoryDto;
import com.project.api.blog.services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		
		Category category=categoryRepo.save(mapper.map(categoryDto, Category.class));
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		
		Category category=categoryRepo.findById(id);
		
		if(category==null)
		{
			throw new ResourceNotFound("Category", "id", id);
		}
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescriptions(categoryDto.getCategoryDescriptions());
		return mapper.map(categoryRepo.save(category), CategoryDto.class);
		
	}

	@Override
	public CategoryDto findById(int id) {
		
		Category category=categoryRepo.findById(id);
		if(category==null)
		{
			throw new ResourceNotFound("Category", "id", id);
		}
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> findAll() {
		List<Category> categoryList=categoryRepo.findAll();
		List<CategoryDto> categoryDtoList=new ArrayList<CategoryDto>();
		categoryList.forEach((category)->{
			categoryDtoList.add(mapper.map(category, CategoryDto.class));
		});
		return categoryDtoList;
	}

	@Override
	public void delete(Integer id) {
		
		categoryRepo.deleteById(id);
		
	}

}
