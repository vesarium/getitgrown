package com.vesarium.main.rest;

import com.vesarium.main.User;
import com.vesarium.main.UserDevices;
import com.vesarium.main.service.UserDevicesService;
import com.vesarium.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserDevicesService userDevicesService;
	private UserService service;

	@Autowired
	public UserController(UserService service, UserDevicesService userDevicesService){
		super();
		this.service = service;
		this.userDevicesService = userDevicesService;
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User newUser){
		return this.service.createUser(newUser);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return this.service.getUsers();
	}

	@GetMapping("/getUser")
	public User getUser(@PathVariable Integer id){
		return this.service.getUser(id);
	}

	@PutMapping("updateUser/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User newUser){
		return this.service.updateUser(id, newUser);
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
	@PostMapping("/addDevice")
	public UserDevices addDevice(@RequestBody UserDevices newDevice){
		System.out.println(newDevice);
		return this.userDevicesService.addDevice(newDevice);
	}

	@GetMapping("/getDevices/{id}")
	public List<UserDevices> getUserDevices(@PathVariable Integer id){
		return this.userDevicesService.getUserDevices(id);
	}

	@DeleteMapping("removeDevice/{id}")
	public ResponseEntity<?> removeDevice(@PathVariable Integer id){
		boolean removed = this.userDevicesService.removeUserDevice(id);
		if(removed){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
