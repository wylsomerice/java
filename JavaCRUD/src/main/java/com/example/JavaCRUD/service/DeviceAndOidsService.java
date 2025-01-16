package com.example.JavaCRUD.service;

import com.example.JavaCRUD.entity.DeviceAndOids;
import com.example.JavaCRUD.repository.DeviceAndOidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceAndOidsService {

    private final DeviceAndOidsRepository deviceAndOidsRepository;

    @Autowired
    public DeviceAndOidsService(DeviceAndOidsRepository deviceAndOidsRepository) {
        this.deviceAndOidsRepository = deviceAndOidsRepository;
    }

    public List<DeviceAndOids> getAllDeviceAndOids() {
        return deviceAndOidsRepository.findAll();
    }

    public DeviceAndOids getDeviceAndOidsById(Integer id) {
        Optional<DeviceAndOids> deviceAndOids = deviceAndOidsRepository.findById(id);
        return deviceAndOids.orElse(null);
    }

    public void createDeviceAndOids(DeviceAndOids deviceAndOids) {
        deviceAndOidsRepository.save(deviceAndOids);
    }

    public void updateDeviceAndOids(DeviceAndOids deviceAndOids) {
        deviceAndOidsRepository.save(deviceAndOids); // Для обновления тоже используем save
    }

    public void deleteDeviceAndOids(Integer id) {
        deviceAndOidsRepository.deleteById(id);
    }
}
