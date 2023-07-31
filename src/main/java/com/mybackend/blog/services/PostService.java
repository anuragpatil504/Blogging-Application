package com.mybackend.blog.services;

import java.util.List;

import com.mybackend.blog.entities.Post;
import com.mybackend.blog.payloads.PostDto;
import com.mybackend.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto,int userId,int categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,int postId);
	
	//Delete
	void deletePost(int postId);
	
	//get all posts
	PostResponse getAllPost(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	//get single post
	PostDto getPostById(int postId);
	
	//get all post by category
	List<PostDto> getPostsByCategory(int categoryId);
	
	//get all post by user
	List<PostDto> getPostsByUser(int userId);
	
	//search post
	List<PostDto> searchPosts(String keyword);
}
