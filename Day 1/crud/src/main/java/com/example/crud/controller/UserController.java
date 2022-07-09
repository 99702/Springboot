package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Create a  user
    @PostMapping("/create")
    public  User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    // Read a user
    @GetMapping("")
    public List<User> getAllUser(){return userService.getAllUser();}

    // Update a user
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody @Valid User user) throws Exception{
        return userService.updateUser(userId, user);
    }

    // delete a user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long userId) throws Exception{
        return userService.deleteUser(userId);
    }

    // get single user
    @GetMapping("/{id}")
    public User singleUser(@PathVariable("id") Long userId) throws  Exception{
        return userService.getSingleUser(userId);
    }
}
