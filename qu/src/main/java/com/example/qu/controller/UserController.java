package com.example.qu.controller;

import com.example.qu.constant.PathConstant;
import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.dto.userdto.RegisterAUserDTO;
import com.example.qu.entity.User;
import com.example.qu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // register a user
    @PostMapping(PathConstant.REGISTER_USER)
    public User registerUser(@RequestBody RegisterAUserDTO user) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return userService.registerUser(user);
    }

    // get a single user
    @PostMapping(PathConstant.SINGLE_USER)
    public GetAUserDTO getSingleUser(@PathVariable("userId") Long userId){return userService.getSingleUser(userId);}

    // get all user
    @PostMapping(PathConstant.ALL_USER)
    public List<GetAUserDTO> getAllUser(){return userService.getAllUser();}


    //search user {name | email | enabled | role | }
    @PostMapping(PathConstant.SEARCH_USER)
    public List<GetAUserDTO> search(@RequestParam Map<String, String> allParams){return userService.searchUsers(allParams);}


    //jpql things
    @PostMapping(PathConstant.GET_ATTR_EXACT)
    public List<GetAUserDTO> fetchByAttrExact(@RequestParam Map<String, String> allParams ) throws ParseException {
        return userService.fetchByAttrExact(allParams);

    };

    @PostMapping(PathConstant.USER_STATS)
    public Map<String, Long> fetchStatistics(){
        return userService.fetchUserStatistics();
    }
}