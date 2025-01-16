package com.example.JavaCRUD.service;

import com.example.JavaCRUD.entity.Events;
import com.example.JavaCRUD.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    private final EventsRepository eventRepository;

    @Autowired
    public EventsService(EventsRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Получить все события
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    // Получить событие по ID
    public Events getEventById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }

    // Сохранить событие
    public void saveEvent(Events event) {
        if (event.getId() != null) {
            // Если id уже существует, пытаемся сохранить как обновление
            eventRepository.save(event);
        } else {
            // Если id отсутствует, сохраняем как новую запись
            eventRepository.save(event);
        }
    }

    // Удалить событие
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
