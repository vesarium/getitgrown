package com.vesarium.main.service;

import com.vesarium.main.Device;
import com.vesarium.main.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceDB implements DeviceService {

    private DeviceRepository repository;

    public DeviceServiceDB(DeviceRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Device createDevice(Device newDevice) {
        return this.repository.save(newDevice);
    }

    @Override
    public List<Device> getDevices() {
        return this.repository.findAll();
    }

    @Override
    public Device getDevice(Integer id) {
       Optional<Device> DeviceOptional = this.repository.findById(id);

        if (DeviceOptional.isPresent()) {
            Device Device = DeviceOptional.get();
            return Device;
        } else {
            throw new EntityNotFoundException("No Device found with id: " + id);
        }
    }

    @Override
    public Device updateDevice(Integer id, Device newDevice) {
        Device existing = this.getDevice(id);

        existing.setName(newDevice.getName());
        existing.setType(newDevice.getType());
        existing.setSerial(newDevice.getSerial());

        return this.repository.save(existing);
    }

    @Override
    public boolean removeDevice(Integer id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

}