package com.bienvenu.controller;

import java.util.ArrayList;
import java.util.List;
import com.bienvenu.model.Event;
import com.bienvenu.model.Interested;
import com.bienvenu.model.Management;
import com.bienvenu.model.User;
import com.bienvenu.service.InterestedService;
import com.bienvenu.service.ManagementService;
import com.bienvenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bienvenu.service.EventService;

@Controller
@RequestMapping("/event/")
public class EventController {

    @Autowired
    public EventService eventService;

    @Autowired
    public UserService userService;

    @Autowired
    public InterestedService interestedService;

    @Autowired
    public ManagementService managementService;

    @GetMapping("/get")
    public String get(Model model, Authentication authentication) {
        // Get logged-in username
        String username = authentication.getName();

        // Find the User entity
        User user = userService.findByUsername(username);

        List<Management> managementList = managementService.findByUser_Id(user.getId());
        List<Event> eventList = new ArrayList<Event>();
        for (Management management : managementList) {
            eventList.add(management.getEvent());
        }

        model.addAttribute("events", eventList);
        return "myEvents";
    }

    // TODO: add EDIT AND DELETE controllers here

    @GetMapping("/myinterests")
    public String eventList(Model model, Authentication authentication) {
        // Get logged-in username
        String username = authentication.getName();

        // Find the User entity
        User user = userService.findByUsername(username);

        List<Interested> interestedList = interestedService.findByUser_Id(user.getId());
        List<Event> eventList = new ArrayList<Event>();
        for (Interested i : interestedList) {
            eventList.add(i.getEvent());
        }

        model.addAttribute("events", eventList);
        return "myInterests";
    }

    @GetMapping("/all")
    public String allEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String createEvent(Model model){
        model.addAttribute("event", new Event());
        return "createEvent";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute("event") Event event, Model model, Authentication authentication){
        // Get logged-in username
        String username = authentication.getName();

        // Find the User entity
        User user = userService.findByUsername(username);

        eventService.save(event);
        Management management = new Management();
        management.setUser(user);
        management.setEvent(event);
        management.setRole("ORGANIZER");
        managementService.save(management);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showEvent(@PathVariable("id") Long id, Model model){
        model.addAttribute("event", eventService.findById(id));
        return "eventDetails";
    }

    @GetMapping("/join/{id}")
    public String join(@PathVariable("id") Long eventId, Model model, Authentication authentication){
        // Get logged-in username
        String username = authentication.getName();

        // Find the User entity
        User user = userService.findByUsername(username);

        // Find the Event entity
        Event event = eventService.findById(eventId);

        // Check duplicate
        boolean alreadyJoined = interestedService.existsByUser_IdAndEvent_Id(user.getId(), eventId);
        if (alreadyJoined) {
            return "redirect:/event/" + eventId + "?interested=true";
        }

        // Update total interest
        event.setTotalInterest(event.getTotalInterest() + 1);
        eventService.save(event);

        // Create Interested entry
        Interested interested = new Interested();
        interested.setUser(user);
        interested.setEvent(event);

        // Save it
        interestedService.save(interested);

        // Optional: redirect back to event details
        return "redirect:/event/" + eventId + "?interested=true";
    }
}
