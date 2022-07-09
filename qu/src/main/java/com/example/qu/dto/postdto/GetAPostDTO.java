package com.example.qu.dto.postdto;

import com.example.qu.dto.userdto.GetAUserDTO;
import lombok.Builder;
import lombok.Data;


public class GetAPostDTO {
//    private GetAUserDTO user;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

//    public GetAUserDTO getUser() {
//        return user;
//    }

//    public void setUser(GetAUserDTO user) {
//        this.user = user;
//    }

    public void setTitle(String title) {
        this.title = title;
//        this.title = "Rajan".equals(title) ? "Fonepay" : title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
