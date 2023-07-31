package com.mybackend.blog.services;

import com.mybackend.blog.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto,int postId);
	void deletComment(int commentId);
}
