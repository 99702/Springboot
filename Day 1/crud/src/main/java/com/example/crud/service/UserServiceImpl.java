package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    // save user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    // get list of user
    public List<User> getAllUser() {return userRepository.findAll();}

    @Override
    // get  single user
    public User getSingleUser(Long userId) throws Exception {
        Optional<User> user =  userRepository.findById(userId);
        if(!user.isPresent()){
            throw new Exception("User not available");
        }
        return user.get();
    };

    @Override
    public User updateUser(Long userId, User user) throws Exception {
        // get the current user userid
        Optional<User> OptionalUserDB = userRepository.findById(userId);
        if(!OptionalUserDB.isPresent()){
            throw new Exception("User not available");
        }
        User userDB = OptionalUserDB.get();
        System.out.println("--------------------------------------------------------");
        System.out.println(userDB.getFirstName());
        System.out.println("--------------------------------------------------------");
        //check if given firstName is not null and not equal to ""
        if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())){
            userDB.setFirstName(user.getFirstName());
        }//else{userDB.setFirstName(userDB.getFirstName());}
        //check if given lastName is not null and not equal to ""
        if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())){
            userDB.setLastName(user.getLastName());
        }// else {userDB.setLastName(userDB.getLastName());};

        //check if given birthday is not null and not equal to ""
        // needs to do more with date
        if(Objects.nonNull(user.getBirthday())){
            userDB.setBirthday(user.getBirthday());
        }// else {userDB.setBirthday(userDB.getBirthday());}

        //check if given email is not null , not equal to ""
        //needs to check if already exists
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }// else {userDB.setEmail(userDB.getEmail());}

        //check if given password is not null and not equal to ""
        if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())){
            userDB.setPassword(userDB.getPassword());
        }
        return userRepository.save(userDB);

    }

    @Override
    public String deleteUser(Long userId) throws Exception{
        // check if user exists
        Optional<User> user =  userRepository.findById(userId);
        if(!user.isPresent()){
            throw new Exception("User not available");
        }
        userRepository.deleteById(userId);
        return "Deleted";
    }
}
