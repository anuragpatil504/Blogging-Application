package com.mybackend.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybackend.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment , Integer>{

}
