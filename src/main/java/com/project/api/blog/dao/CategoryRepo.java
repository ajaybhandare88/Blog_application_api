package com.project.api.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	public Category findById(int id);

}
