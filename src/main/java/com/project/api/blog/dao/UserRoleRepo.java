package com.project.api.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.api.blog.entity.Role;

@Repository
public interface UserRoleRepo extends JpaRepository<Role, Integer>{

	public Role findById(int id);
}
