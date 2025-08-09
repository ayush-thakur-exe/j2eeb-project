package com.bienvenu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bienvenu.model.Event;
import com.bienvenu.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }
}
