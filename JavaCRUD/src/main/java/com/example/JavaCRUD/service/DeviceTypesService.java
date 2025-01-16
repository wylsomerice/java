package com.example.JavaCRUD.service;

import com.example.JavaCRUD.entity.DeviceTypes;
import com.example.JavaCRUD.repository.DeviceTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceTypesService {
    private final DeviceTypesRepository repository;

    public DeviceTypesService(DeviceTypesRepository repository) {
        this.repository = repository;
    }

    public List<DeviceTypes> getAllDeviceTypes() {
        return repository.findAll();
    }

    public DeviceTypes getDeviceTypeById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void saveDeviceType(DeviceTypes deviceType) {
        repository.save(deviceType);
    }

    public void deleteDeviceType(Integer id) {
        repository.deleteById(id);
    }
}
