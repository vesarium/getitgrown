package com.vesarium.main.rest;

import com.vesarium.main.Device;
import com.vesarium.main.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private DeviceService service;

    @Autowired
    public DeviceController(DeviceService service){
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public Device createDevice(@RequestBody Device newDevice){
        return this.service.createDevice(newDevice);
    }

    @GetMapping("/getDevices")
    public List<Device> getDevices(){
        return this.service.getDevices();
    }

    @GetMapping("/getDevice")
    public Device getDevice(@PathVariable Integer id){
        return this.service.getDevice(id);
    }

    @DeleteMapping("removeDevice/{id}")
    public ResponseEntity<?> removeDevice(@PathVariable Integer id){
        boolean removed = this.service.removeDevice(id);
        if(removed){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
