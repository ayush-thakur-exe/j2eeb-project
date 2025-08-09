package com.bienvenu.service;

import java.util.List;

import com.bienvenu.model.Event;

public interface EventService {
    Event save(Event event);
    List<Event> findAll();
    Event findById(Long id);
}
