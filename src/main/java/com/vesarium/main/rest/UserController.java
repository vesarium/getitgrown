package com.vesarium.main.rest;

import com.vesarium.main.User;
import com.vesarium.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController

public class UserController {

	private List<User> users = new ArrayList<>();
	private UserService service;

	@Autowired
	public UserController(UserService service){
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User newUser){
		this.users.add(newUser);

		return this.users.get(this.users.size()-1);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return this.users;
	}

	@GetMapping("/getUser")
	public User getUser(@PathVariable Integer id){
		return this.users.get(id);
	}

	@DeleteMapping("removeUser/{id}")
	public ResponseEntity<?> removeUser(@PathVariable Integer id){
		boolean removed = this.service.removeUser(id);
		if(removed){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}







}
