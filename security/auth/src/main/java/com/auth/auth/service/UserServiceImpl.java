package com.auth.auth.service;

import com.auth.auth.domain.Role;
import com.auth.auth.domain.User;
import com.auth.auth.repository.RoleRepository;
import com.auth.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements  UserService{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving {} to the database", role.getName());
        return roleRepository.save(role);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.fetchByUserName(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Adding role: {} to user: {}", role.getName(), user.getName());
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {} ", username);
        return userRepository.fetchByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userRepository.findAll();
    }
}