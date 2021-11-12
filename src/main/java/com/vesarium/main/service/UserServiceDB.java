package com.vesarium.main.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.vesarium.main.User;
import com.vesarium.main.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDB implements UserService {

    private UserRepository repository;

    public UserServiceDB(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public User createUser(User newUser) {
        return this.repository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return this.repository.findAll();
    }

    @Override
    public User getUser(Integer id) {
       Optional<User> userOptional = this.repository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        } else {
            throw new EntityNotFoundException("No user found with id: " + id);
        }
    }

    @Override
    public User updateUser(Integer id, User newUser) {
        User existing = this.getUser(id);

        existing.setName(newUser.getName());
        existing.setEmail(newUser.getEmail());
        existing.setInfo(newUser.getInfo());

        return this.repository.save(existing);
    }

    @Override
    public boolean removeUser(Integer id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

}