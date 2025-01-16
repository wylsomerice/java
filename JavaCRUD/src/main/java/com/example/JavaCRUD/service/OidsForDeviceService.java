package com.example.JavaCRUD.service;

import com.example.JavaCRUD.entity.OidsForDevice;
import com.example.JavaCRUD.repository.OidsForDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OidsForDeviceService {

    @Autowired
    private OidsForDeviceRepository oidsForDeviceRepository;

    public List<OidsForDevice> getAllOidsForDevice() {
        return oidsForDeviceRepository.findAll();
    }

    public OidsForDevice getOidsForDeviceByKey(Integer key) {
        return oidsForDeviceRepository.findById(key).orElse(null);
    }

    public OidsForDevice saveOidsForDevice(OidsForDevice oidsForDevice) {
        return oidsForDeviceRepository.save(oidsForDevice);
    }

    public void deleteOidsForDevice(Integer key) {
        oidsForDeviceRepository.deleteById(key);
    }
}
