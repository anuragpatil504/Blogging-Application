package com.mybackend.blog.services;

import java.util.List;

import com.mybackend.blog.payloads.CategoryDto;

public interface CategoryService {
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto,int categoryId);
	
	void deleteCategory(int categoryId);
	
	CategoryDto getCategory(int categoryId);
	
	List<CategoryDto> getCategories();
}
