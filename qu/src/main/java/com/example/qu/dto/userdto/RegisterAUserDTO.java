package com.example.qu.dto.userdto;

import lombok.Data;
import java.util.Date;

@Data
public class RegisterAUserDTO {
    private String name;
    private String email;
    private Date dob;
    private String mobile;
    private String password;
    private String profilePic;
}
