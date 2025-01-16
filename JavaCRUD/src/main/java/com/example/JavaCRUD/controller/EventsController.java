package com.example.JavaCRUD.controller;

import com.example.JavaCRUD.entity.Events;
import com.example.JavaCRUD.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventService;

    @Autowired
    public EventsController(EventsService eventService) {
        this.eventService = eventService;
    }

    // Главная страница с перечнем событий
    @GetMapping
    public String listEvents(Model model) {
        List<Events> eventList = eventService.getAllEvents();
        model.addAttribute("eventList", eventList);
        return "events/list";
    }

    // Страница для добавления нового события
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Events());
        return "events/create";
    }

    // Обработка формы для добавления нового события
    @PostMapping("/new")
    public String createEvent(@ModelAttribute Events event) {
        eventService.saveEvent(event); // Если id пустое, оно будет сгенерировано автоматически
        return "redirect:/events";
    }

    // Страница для редактирования события
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Events event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "events/edit";
    }

    // Обработка формы для редактирования события
    @PostMapping("/edit")
    public String editEvent(@ModelAttribute Events event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    // Удаление события
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Integer id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
