package com.example.qu.controller;

import com.example.qu.constant.PathConstant;
import com.example.qu.dto.postdto.GetAPostDTO;
import com.example.qu.dto.postdto.PostCreateDTO;
import com.example.qu.entity.Post;

import com.example.qu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping(PathConstant.CREATE_POST)
    public PostCreateDTO createPost(@RequestBody Post post, @PathVariable("userId") Long userId){
        return postService.createPost(post, userId);
    }

    @PostMapping(PathConstant.FIND_POST)
    public GetAPostDTO getByPostTitle(@RequestParam("title") String title) {return postService.fetchPostTitle(title);}

    @PostMapping(PathConstant.FIND_POST_DESC)
    public List<GetAPostDTO> getByPostDescription(@RequestParam("description") String desc) {return postService.fetchPostByDescription(desc);}

    @PostMapping(PathConstant.CURRENT_USER_POST)
    public List<GetAPostDTO> getCurrentUserPost(@PathVariable("userId") Long userId ) {return postService.fetchCurrentUserPost(userId);}



//    @GetMapping(PathConstant.HIBERNATE)
//    public ResponseEntity<Object> getAllPostHibernate() {
//        return new ResponseEntity<>(postService.fetchPostHibernate(), HttpStatus.OK);
////        return postService.fetchThroughDto();
//    }
}
