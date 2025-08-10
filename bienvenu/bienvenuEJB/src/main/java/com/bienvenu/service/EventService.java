package com.bienvenu.service;

import java.util.List;
import java.util.Optional;

import com.bienvenu.model.Event;

public interface EventService {
    Event save(Event event);
    List<Event> findAll();
    Event findById(Long id);
    boolean deleteById(Long id);
    Optional<Event> findByIdWithLinks(Long id);
    List<Event> search(String q);
}
