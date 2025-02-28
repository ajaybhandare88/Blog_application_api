package com.project.api.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.api.blog.entity.Post;

import jakarta.websocket.server.PathParam;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	public Post findById(int id);
	public int deleteById(int id);
	
	@Query("from Post As p inner join p.user As u where u.id=:userId")
	public List<Post> findByUserId(@Param("userId") int id);
	
	@Query("from Post As p inner join p.category As c where c.categoryID=:categoryId")
	public List<Post> findByCategoryId(@Param("categoryId") int id);
	
	@Query("from Post As p inner join p.user As u inner join p.category As c where u.id=:userId and c.categoryID=:categoryId")
	public List<Post> findByUserIdAndCategoryId(@Param("userId") int userId,@Param("categoryId") int categoryId);
	
	@Query("from Post As p Where p.title like :title")
	public List<Post> searchByTitle(@Param("title")String title);
	
}
