package com.vesarium.main.service;
import com.vesarium.main.UserDevices;

import com.vesarium.main.repository.UserDevicesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public List<UserDevices> getUserDevices(Integer id)
    {
        List<UserDevices> devicesList= this.userDevicesRepository.findByUserid(id);
        return devicesList;
    }

    @Override
    public boolean removeUserDevice(Integer deviceid) {
        this.userDevicesRepository.deleteById(deviceid);
        return !this.userDevicesRepository.existsById(deviceid);
    }


}