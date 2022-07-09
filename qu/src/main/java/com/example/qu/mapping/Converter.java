package com.example.qu.mapping;

import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.dto.userdto.RegisterAUserDTO;
import com.example.qu.entity.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {
    public User DTOToEntity(RegisterAUserDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setDob(dto.getDob());
        user.setMobile(dto.getMobile());
        user.setPassword(dto.getPassword());
        user.setProfilePic(dto.getProfilePic());
        return user;
    }

    public GetAUserDTO EntityToDto(User user){
        GetAUserDTO getAUserDTO = new GetAUserDTO();
        getAUserDTO.setName(user.getName());
        getAUserDTO.setEmail(user.getEmail());
        getAUserDTO.setMobile(user.getMobile());
        getAUserDTO.setProfilePic(user.getProfilePic());
        return getAUserDTO;
    }

    public List<GetAUserDTO> EntityListToDtoList(List<User> userList){
        List<GetAUserDTO> userDTOList = new ArrayList<>();
        for(User user: userList){
            GetAUserDTO getAUserDTO = new GetAUserDTO();
            getAUserDTO.setName(user.getName());
            getAUserDTO.setEmail(user.getEmail());
            getAUserDTO.setProfilePic(user.getProfilePic());
            getAUserDTO.setMobile(user.getMobile());
            userDTOList.add(getAUserDTO);
        }
        return userDTOList;
    }
}
