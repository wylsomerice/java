package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.DeviceAndOids;
import com.example.JavaCRUD.service.DeviceAndOidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deviceAndOids")
public class DeviceAndOidsController {

    private final DeviceAndOidsService deviceAndOidsService;

    @Autowired
    public DeviceAndOidsController(DeviceAndOidsService deviceAndOidsService) {
        this.deviceAndOidsService = deviceAndOidsService;
    }

    // Главная страница с перечнем записей
    @GetMapping
    public String listDeviceAndOids(Model model) {
        List<DeviceAndOids> deviceAndOidsList = deviceAndOidsService.getAllDeviceAndOids();
        System.out.println("Полученные данные: " + deviceAndOidsList);
        model.addAttribute("deviceAndOidsList", deviceAndOidsList);
        return "deviceAndOids/list";
    }

    // Страница для добавления новой записи
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("deviceAndOids", new DeviceAndOids());
        return "deviceAndOids/create";
    }

    // Обработка формы для добавления новой записи
    @PostMapping("/new")
    public String createDeviceAndOids(@ModelAttribute DeviceAndOids deviceAndOids) {
        deviceAndOidsService.createDeviceAndOids(deviceAndOids);
        return "redirect:/deviceAndOids";
    }

    // Страница для редактирования записи
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        DeviceAndOids deviceAndOids = deviceAndOidsService.getDeviceAndOidsById(id);
        model.addAttribute("deviceAndOids", deviceAndOids);
        return "deviceAndOids/edit";
    }

    // Обработка формы для редактирования записи
    @PostMapping("/edit")
    public String editDeviceAndOids(@ModelAttribute DeviceAndOids deviceAndOids) {
        deviceAndOidsService.updateDeviceAndOids(deviceAndOids);
        return "redirect:/deviceAndOids";
    }

    // Удаление записи
    @GetMapping("/delete/{id}")
    public String deleteDeviceAndOids(@PathVariable("id") Integer id) {
        deviceAndOidsService.deleteDeviceAndOids(id);
        return "redirect:/deviceAndOids";
    }
}

