package com.example.JavaCRUD.repository;

import com.example.JavaCRUD.entity.DeviceAndOids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAndOidsRepository extends JpaRepository<DeviceAndOids, Integer> {

}
