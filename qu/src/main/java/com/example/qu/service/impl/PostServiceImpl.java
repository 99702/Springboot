package com.example.qu.service.impl;

import com.example.qu.dto.postdto.GetAPostDTO;
import com.example.qu.dto.postdto.PostCreateDTO;
import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.entity.Post;
import com.example.qu.entity.User;
import com.example.qu.mapping.PostConverter;
import com.example.qu.repository.PostRepository;
import com.example.qu.repository.UserRepository;
import com.example.qu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequestMapping("/post")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PostCreateDTO createPost(Post post, Long userId) {
        //get user from userId
        User user = userRepository.findById(userId).get();
        post.setUser(user);
        return postConverter.EntityToDTO(postRepository.save(post), userId);
    }

    @Override
    public List<GetAPostDTO> getAllPost() {
        return postConverter.EntityListToDTOList(postRepository.findAll());
    }

    @Override
    public List<GetAPostDTO> fetchThroughDto(){
        List<Post> postList = postRepository.findAll();
        List<GetAPostDTO> getAPostDTOList = new ArrayList<>();
        for (Post post : postList) {
            GetAPostDTO getAPostDTO = this.setterForGetAPostDTO(post);
            getAPostDTOList.add(getAPostDTO);
        }
        return getAPostDTOList;
    }

    @Override
    public GetAPostDTO fetchPostTitle(String title) {
        Post post = postRepository.fetchPostByTitle(title);
        GetAPostDTO getAPostDTO = this.setterForGetAPostDTO(post);
        return getAPostDTO;
    }

    @Override
    public List<GetAPostDTO> fetchPostByDescription(String desc) {
        List<Post> postList = postRepository.fetchPostDescription(desc);
        List<GetAPostDTO> getAPostDTOList = new ArrayList<>();
        for(Post post: postList){
            GetAPostDTO getAPostDTO = this.setterForGetAPostDTO(post);
            getAPostDTOList.add(getAPostDTO);
        }
        return getAPostDTOList;
    }

    @Override
    public List<GetAPostDTO> fetchCurrentUserPost(Long userId) {
        List<Post> postList = postRepository.fetchCurrentUserPost(userId);
        List<GetAPostDTO> getAPostDTOList = new ArrayList<>();
        for(Post post: postList){
            GetAPostDTO getAPostDTO = this.setterForGetAPostDTO(post);
            getAPostDTOList.add(getAPostDTO);
        }
        return getAPostDTOList;
    }

    private GetAPostDTO setterForGetAPostDTO(Post post) {
        GetAPostDTO getAPostDTO = new GetAPostDTO();
        getAPostDTO.setTitle(post.getTitle());
        getAPostDTO.setDescription(post.getDescription());

        //get user from post
        User user = post.getUser();
        GetAUserDTO getAUserDTO = new GetAUserDTO();
        getAUserDTO.setName(user.getName());
//        getAPostDTO.setUser(getAUserDTO); //add it to user
        return getAPostDTO;
    }
}
