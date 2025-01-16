package com.example.JavaCRUD.service;

import com.example.JavaCRUD.entity.DeviceForMonitoring;
import com.example.JavaCRUD.repository.DeviceForMonitoringRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceForMonitoringService {

    private final DeviceForMonitoringRepository repository;

    public DeviceForMonitoringService(DeviceForMonitoringRepository repository) {
        this.repository = repository;
    }

    public List<DeviceForMonitoring> getAllDevices() {
        return repository.findAll();
    }

    public DeviceForMonitoring getDeviceById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void createDevice(DeviceForMonitoring device) {
        repository.save(device);
    }

    public void updateDevice(DeviceForMonitoring device) {
        repository.save(device);
    }

    public void deleteDevice(Integer id) {
        repository.deleteById(id);
    }
}