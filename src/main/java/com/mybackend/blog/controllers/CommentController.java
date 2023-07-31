package com.mybackend.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybackend.blog.entities.Comment;
import com.mybackend.blog.payloads.ApiResponse;
import com.mybackend.blog.payloads.CommentDto;
import com.mybackend.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable int postId){
		CommentDto createComment = this.commentService.createComment(comment, postId);
		
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
	}
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable int commentId){
		this.commentService.deletComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted",true),HttpStatus.OK);
	}
}
