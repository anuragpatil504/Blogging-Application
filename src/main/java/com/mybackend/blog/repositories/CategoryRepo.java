package com.mybackend.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybackend.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
