package com.project.api.blog;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.api.blog.dao.UserRoleRepo;
import com.project.api.blog.entity.Role;
import com.project.api.blog.services.UserServices;

@SpringBootApplication
public class BlogApiProjectApplication {
	
	@Autowired
	UserRoleRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(BlogApiProjectApplication.class, args);
		
	}
	
	

	@Bean
	public ModelMapper modelmapper()
	{
		ModelMapper m=new ModelMapper();
		return m;
	}
	
	

}
