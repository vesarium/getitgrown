package com.vesarium.main.service;
import com.vesarium.main.UserDevices;

import com.vesarium.main.repository.UserDevicesRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDevicesServiceDB implements UserDevicesService {

    private UserDevicesRepository userDevicesRepository;

    public UserDevicesServiceDB(UserDevicesRepository repository) {
        super();
        this.userDevicesRepository = repository;
    }

    @Override
    public UserDevices addDevice(UserDevices newDevice) {
        return this.userDevicesRepository.save(newDevice);
    }


}