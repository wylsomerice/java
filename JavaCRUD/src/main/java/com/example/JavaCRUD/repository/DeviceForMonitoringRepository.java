package com.example.JavaCRUD.repository;

import com.example.JavaCRUD.entity.DeviceForMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceForMonitoringRepository extends JpaRepository<DeviceForMonitoring, Integer> {

}