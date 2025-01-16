package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.DeviceForMonitoring;
import com.example.JavaCRUD.service.DeviceForMonitoringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deviceForMonitoring")
public class DeviceForMonitoringController {

    private final DeviceForMonitoringService service;

    public DeviceForMonitoringController(DeviceForMonitoringService service) {
        this.service = service;
    }

    @GetMapping
    public String listDevices(Model model) {
        List<DeviceForMonitoring> devices = service.getAllDevices();
        model.addAttribute("devices", devices);
        return "deviceForMonitoring/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("device", new DeviceForMonitoring());
        return "deviceForMonitoring/create";
    }

    @PostMapping("/new")
    public String createDevice(@ModelAttribute DeviceForMonitoring device) {
        service.createDevice(device);
        return "redirect:/deviceForMonitoring";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        DeviceForMonitoring device = service.getDeviceById(id);
        model.addAttribute("device", device);
        return "deviceForMonitoring/edit";
    }

    @PostMapping("/edit")
    public String editDevice(@ModelAttribute DeviceForMonitoring device) {
        service.updateDevice(device);
        return "redirect:/deviceForMonitoring";
    }

    @GetMapping("/delete/{id}")
    public String deleteDevice(@PathVariable("id") Integer id) {
        service.deleteDevice(id);
        return "redirect:/deviceForMonitoring";
    }
}

