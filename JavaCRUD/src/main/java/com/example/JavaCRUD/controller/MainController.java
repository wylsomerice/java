package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.DeviceForMonitoring;
import com.example.JavaCRUD.service.DeviceForMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
}