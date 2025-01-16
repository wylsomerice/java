package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.DeviceTypes;
import com.example.JavaCRUD.service.DeviceTypesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deviceTypes")
public class DeviceTypesController {
    private final DeviceTypesService service;

    public DeviceTypesController(DeviceTypesService service) {
        this.service = service;
    }

    @GetMapping
    public String listDeviceTypes(Model model) {
        List<DeviceTypes> deviceTypesList = service.getAllDeviceTypes();
        model.addAttribute("deviceTypesList", deviceTypesList);
        return "deviceTypes/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("deviceType", new DeviceTypes());
        return "deviceTypes/create";
    }

    @PostMapping("/new")
    public String createDeviceType(@ModelAttribute DeviceTypes deviceType) {
        service.saveDeviceType(deviceType);
        return "redirect:/deviceTypes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        DeviceTypes deviceType = service.getDeviceTypeById(id);
        model.addAttribute("deviceType", deviceType);
        return "deviceTypes/edit";
    }

    @PostMapping("/edit")
    public String editDeviceType(@ModelAttribute DeviceTypes deviceType) {
        service.saveDeviceType(deviceType);
        return "redirect:/deviceTypes";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeviceType(@PathVariable Integer id) {
        service.deleteDeviceType(id);
        return "redirect:/deviceTypes";
    }
}
