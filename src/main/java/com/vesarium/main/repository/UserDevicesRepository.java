package com.vesarium.main.repository;

import com.vesarium.main.UserDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDevicesRepository extends JpaRepository<UserDevices, Integer> {
}
