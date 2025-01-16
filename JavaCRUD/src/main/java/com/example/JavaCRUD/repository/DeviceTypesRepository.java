package com.example.JavaCRUD.repository;

import com.example.JavaCRUD.entity.DeviceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypesRepository extends JpaRepository<DeviceTypes, Integer> {

}
