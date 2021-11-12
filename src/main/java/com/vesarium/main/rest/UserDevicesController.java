package com.vesarium.main.rest;

import com.vesarium.main.UserDevices;
import com.vesarium.main.service.UserDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class UserDevicesController {

	private UserDevicesService userDevicesService;

	@Autowired
	public UserDevicesController(UserDevicesService userDevicesService){
		super();
		this.userDevicesService = userDevicesService;
	}

	@PostMapping("/addDevice")
	public UserDevices addDevice(@RequestBody UserDevices newDevice){
		return this.userDevicesService.addDevice(newDevice);
	}





}
