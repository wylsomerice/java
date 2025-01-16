package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.OidsForDevice;
import com.example.JavaCRUD.service.OidsForDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/oidsForDevice")
public class OidsForDeviceController {

    @Autowired
    private OidsForDeviceService oidsForDeviceService;

    @GetMapping
    public String listOidsForDevice(Model model) {
        List<OidsForDevice> oidsForDeviceList = oidsForDeviceService.getAllOidsForDevice();
        model.addAttribute("oidsForDeviceList", oidsForDeviceList);
        return "oidsForDevice/list";  // Шаблон для списка
    }

    @GetMapping("/edit/{key}")
    public String editOidsForDevice(@PathVariable("key") Integer key, Model model) {
        OidsForDevice oidsForDevice = oidsForDeviceService.getOidsForDeviceByKey(key);
        if (oidsForDevice != null) {
            model.addAttribute("oidsForDevice", oidsForDevice);
            return "oidsForDevice/edit";  // Шаблон для редактирования
        }
        return "redirect:/oidsForDevice";
    }

    @PostMapping("/edit")
    public String saveOidsForDevice(@ModelAttribute("oidsForDevice") OidsForDevice oidsForDevice) {
        oidsForDeviceService.saveOidsForDevice(oidsForDevice);
        return "redirect:/oidsForDevice";
    }

    @GetMapping("/create")
    public String createOidsForDevice(Model model) {
        model.addAttribute("oidsForDevice", new OidsForDevice());
        return "oidsForDevice/create";  // Шаблон для создания
    }

    @PostMapping("/create")
    public String saveNewOidsForDevice(@ModelAttribute("oidsForDevice") OidsForDevice oidsForDevice) {
        oidsForDeviceService.saveOidsForDevice(oidsForDevice);
        return "redirect:/oidsForDevice";
    }

    @GetMapping("/delete/{key}")
    public String deleteOidsForDevice(@PathVariable("key") Integer key) {
        oidsForDeviceService.deleteOidsForDevice(key);
        return "redirect:/oidsForDevice";
    }
}
