package com.example.qu.controller;

import com.example.qu.constant.PathConstant;
import com.example.qu.dto.commentdto.CommentCreateDTO;
import com.example.qu.entity.Comment;
import com.example.qu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // create a comment for that postid given a userid
    @PostMapping(PathConstant.CREATE_POST)
    public CommentCreateDTO createComment(@RequestBody Comment comment, @PathVariable("userId") Long userId, @PathVariable("postId") Long postId){
        return commentService.createComment(comment, userId, postId);
    }

}
