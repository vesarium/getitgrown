package com.vesarium.main.service;

import com.vesarium.main.UserDevices;

import java.util.List;

public interface UserDevicesService{
    UserDevices addDevice(UserDevices addDevice);
    List<UserDevices> getUserDevices(Integer id);
    boolean removeUserDevice(Integer deviceid);
}
