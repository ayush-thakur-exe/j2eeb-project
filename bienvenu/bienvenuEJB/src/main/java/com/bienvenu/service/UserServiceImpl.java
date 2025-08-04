package com.bienvenu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bienvenu.model.User;
import com.bienvenu.repository.UserRepository;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    
}
