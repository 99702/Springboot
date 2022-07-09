package com.example.qu.dto.commentdto;


import com.example.qu.entity.Post;
import com.example.qu.entity.User;
import lombok.Data;

@Data
public class CommentCreateDTO {
    private User user;
    private Post post;
    private String comment;
}
