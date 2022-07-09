package com.example.qu.service;


import com.example.qu.dto.postdto.GetAPostDTO;
import com.example.qu.dto.postdto.PostCreateDTO;
import com.example.qu.entity.Post;
import com.example.qu.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    /**
     * Example of conversion of entity to DTO
     * @param post
     * @param userId
     * @return
     */
    PostCreateDTO createPost(Post post, Long userId);

    List<GetAPostDTO> getAllPost();

    List<GetAPostDTO> fetchThroughDto();

    GetAPostDTO fetchPostTitle(String title);

    List<GetAPostDTO> fetchPostByDescription(String desc);

    List<GetAPostDTO> fetchCurrentUserPost(Long userId);
}