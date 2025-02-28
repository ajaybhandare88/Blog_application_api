package com.project.api.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findById(int id);
	public void deleteById(int id);
	public User findByEmail(String email);

}
