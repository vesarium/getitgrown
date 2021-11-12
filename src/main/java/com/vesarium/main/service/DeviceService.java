package com.vesarium.main.service;

import com.vesarium.main.Device;

import java.util.List;

public interface DeviceService {
    Device createDevice(Device newDevice);

    List<Device> getDevices();

    Device getDevice(Integer id);

    Device updateDevice(Integer id, Device newDevice);

    boolean removeDevice(Integer id);
}
