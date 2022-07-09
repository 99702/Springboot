package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //save
    public User saveUser(User user);

    // get list of user
    public List<User> getAllUser();

    // get single user
    public User getSingleUser(Long userId) throws  Exception;

    // update a user
    public User updateUser(Long userId, User user) throws Exception;

    // delete user
    public String deleteUser(Long userId) throws  Exception;

}
