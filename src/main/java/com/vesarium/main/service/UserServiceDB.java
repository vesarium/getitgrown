package com.vesarium.main.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.vesarium.main.User;
import org.springframework.stereotype.Service;

@Service
public class PuppyServiceDB implements UserService {

    private UserRepository repository;

    public PuppyServiceDB(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public User createPuppy(User newUser) {
        return this.repository.save(newUser);
    }

    @Override
    public List<Puppy> getPuppies() {
        return this.repo.findAll();
    }

    @Override
    public Puppy getPuppy(Integer id) {
//		return this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException("No puppy found with id: " + id));
        Optional<Puppy> puppyOptional = this.repo.findById(id);

        if (puppyOptional.isPresent()) {
            Puppy puppy = puppyOptional.get();
            return puppy;
        } else {
            throw new EntityNotFoundException("No puppy found with id: " + id);
        }
    }

    @Override
    public Puppy replacePuppy(Integer id, Puppy newPuppy) {
        Puppy existing = this.getPuppy(id);

        existing.setBreed(newPuppy.getBreed());
        existing.setHeight(newPuppy.getHeight());
        existing.setName(newPuppy.getName());

        return this.repo.save(existing);
    }

    @Override
    public boolean removePuppy(Integer id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}