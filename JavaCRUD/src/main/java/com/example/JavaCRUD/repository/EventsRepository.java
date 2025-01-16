package com.example.JavaCRUD.repository;

import com.example.JavaCRUD.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer> {
}
