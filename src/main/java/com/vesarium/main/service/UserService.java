package com.vesarium.main.service;

import com.vesarium.main.User;

import java.util.List;

public interface UserService {
    User createUser(User newUser);

    List<User> getUsers();

    User getUser(Integer id);

    User updateUser(Integer id, User newUser);

    boolean removeUser(Integer id);
}
