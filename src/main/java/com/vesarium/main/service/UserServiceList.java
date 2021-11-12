package com.vesarium.main.service;

import com.vesarium.main.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceList implements UserService{

    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User newUser) { // a puppy object in the request + response
        this.users.add(newUser);
        return this.users.get(this.users.size() - 1);
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public User getUser(Integer id) {
        return this.users.get(id);
    }

    @Override
    public User updateUser(Integer id, User newPuppy) {
        return this.users.set(id, newPuppy); // replaces the puppy at that index
    }

    @Override
    public boolean removeUser(Integer id) {
        User toRemove = this.users.get(id);
        this.users.remove(id.intValue());
        return !this.users.contains(toRemove);
    }

}