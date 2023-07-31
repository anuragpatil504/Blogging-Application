package com.mybackend.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybackend.blog.entities.Category;
import com.mybackend.blog.entities.Post;
import com.mybackend.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);
	
}
