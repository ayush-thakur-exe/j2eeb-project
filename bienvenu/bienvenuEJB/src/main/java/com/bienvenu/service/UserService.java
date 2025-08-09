package com.bienvenu.service;

import java.util.List;

import com.bienvenu.model.User;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByUsername(String username);
    User create(User user);
}
