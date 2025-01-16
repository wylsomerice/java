package com.example.JavaCRUD.repository;

import com.example.JavaCRUD.entity.OidsForDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OidsForDeviceRepository extends JpaRepository<OidsForDevice, Integer> {

}