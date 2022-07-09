package com.example.qu.mapping;

import com.example.qu.dto.postdto.GetAPostDTO;
import com.example.qu.dto.postdto.PostCreateDTO;
import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.entity.Post;
import com.example.qu.entity.User;
import com.example.qu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverter {
    @Autowired
    private  UserRepository userRepository;
    public PostCreateDTO EntityToDTO(Post post, Long userId){
        // get user
        User user = userRepository.findById(userId).get();

        // import GetAUserDTO , put user detial in it
        GetAUserDTO userDTO = new GetAUserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setProfilePic(user.getProfilePic());
        userDTO.setMobile(user.getMobile());

        // create post , and put data in it
        PostCreateDTO postCreateDTO = new PostCreateDTO();
        postCreateDTO.setUser(userDTO);
        postCreateDTO.setTitle(post.getTitle());
        postCreateDTO.setDescription(post.getDescription());
        return postCreateDTO;
    }

    public List<GetAPostDTO> EntityListToDTOList(List<Post> postList){
        //create a array to save individual GetAPostDTO objects
        List<GetAPostDTO> getAPostDTOS = new ArrayList<>();
        for(Post post: postList){
            // get that post
//            GetAPostDTO getAPostDTO = new GetAPostDTO();
//
//            // get user of that post and add to GetAUserDTO
//            User user = post.getUser();
//            GetAUserDTO getAUserDTO = new GetAUserDTO();
//            getAUserDTO.setName(user.getName());
//            getAUserDTO.setEmail(user.getEmail());
//            getAUserDTO.setProfilePic(user.getProfilePic());
//
////            getAPostDTO.setUser(getAUserDTO);
//            getAPostDTO.setTitle(post.getTitle());
//            getAPostDTO.setDescription(post.getDescription());
//
//            getAPostDTOS.add(getAPostDTO);
        }
        return getAPostDTOS;
    }
}
