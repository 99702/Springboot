package com.example.qu.mapping;

import com.example.qu.dto.commentdto.CommentCreateDTO;
import com.example.qu.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public CommentCreateDTO DTOToEntity(Comment comment){
        CommentCreateDTO  commentCreateDTO = new CommentCreateDTO();
        commentCreateDTO.setComment(comment.getComment());
        commentCreateDTO.setUser(comment.getUser());
        commentCreateDTO.setComment(comment.getComment());
        return commentCreateDTO;
    }
}
