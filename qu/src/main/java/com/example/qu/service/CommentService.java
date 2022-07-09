package com.example.qu.service;

import com.example.qu.dto.commentdto.CommentCreateDTO;
import com.example.qu.entity.Comment;

public interface CommentService {
    public CommentCreateDTO createComment(Comment comment, Long userId, Long postId);

}
