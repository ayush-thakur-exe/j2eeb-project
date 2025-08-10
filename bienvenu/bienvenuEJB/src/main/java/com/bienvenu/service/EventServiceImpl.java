package com.bienvenu.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import com.bienvenu.model.TicketLinks;
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
        normalizeTicketLinks(event);

        // If updating, load existing to preserve relationships
        if (event.getId() != null) {
            Event existing = eventRepository.findByIdWithLinks(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Event not found: " + event.getId()));

            existing.setTitle(event.getTitle());
            existing.setDescription(event.getDescription());
            existing.setPlace(event.getPlace());
            existing.setDatetime(event.getDatetime());
            existing.setLongitude(event.getLongitude());
            existing.setLatitude(event.getLatitude());
            existing.setTotalInterest(event.getTotalInterest());

            existing.getTicketLinks().clear();
            for (TicketLinks link : event.getTicketLinks()) {
                link.setEvent(existing);
                existing.getTicketLinks().add(link);
            }

            return eventRepository.save(existing);
        }

        // Create new
        return eventRepository.save(event);
    }

    private void normalizeTicketLinks(Event event) {
        if (event.getTicketLinks() != null) {
            event.getTicketLinks().removeIf(link ->
                    (link.getPlatform() == null || link.getPlatform().isBlank()) &&
                            (link.getLink() == null || link.getLink().isBlank())
            );
            event.getTicketLinks().forEach(link -> link.setEvent(event));
        }
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

    @Override
    public boolean deleteById(Long id) {
        try{
            eventRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println("[BACKEND ERROR] Could not delete: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Event> findByIdWithLinks(Long id) {
        Optional<Event> event = eventRepository.findByIdWithLinks(id);
        return Optional.ofNullable(event.orElse(null));
    }

    @Override
    public List<Event> search(String q) {
        if (q == null || q.isBlank()) return findAll();
        return eventRepository.search(q.trim());
    }
}
