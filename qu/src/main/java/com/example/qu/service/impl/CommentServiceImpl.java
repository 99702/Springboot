package com.example.qu.service.impl;

import com.example.qu.dto.commentdto.CommentCreateDTO;
import com.example.qu.entity.Comment;
import com.example.qu.entity.Post;
import com.example.qu.entity.User;
import com.example.qu.mapping.CommentConverter;
import com.example.qu.repository.CommentRepository;
import com.example.qu.repository.PostRepository;
import com.example.qu.repository.UserRepository;
import com.example.qu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    CommentConverter commentConverter;

    public CommentCreateDTO createComment(Comment comment, Long userId, Long postId){

        // get that user from userId
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();
        comment.setUser(user);
        comment.setPost(post);
        return commentConverter.DTOToEntity(comment);
    }
}
