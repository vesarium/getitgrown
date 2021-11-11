package com.vesarium.main.rest;

import com.vesarium.main.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class UserController {

	private List<User> users = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		this.users.add(newUser);
		User responseBody = this.users.get(this.users.size()-1);
		return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return this.users;
	}

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable Integer id){
		return this.users.get(id);
	}





	

}
