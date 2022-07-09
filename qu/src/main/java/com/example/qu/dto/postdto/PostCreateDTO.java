package com.example.qu.dto.postdto;

import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.entity.User;
import lombok.Data;

@Data
public class PostCreateDTO {
    private GetAUserDTO user;
    private String title;
    private String description;
}
