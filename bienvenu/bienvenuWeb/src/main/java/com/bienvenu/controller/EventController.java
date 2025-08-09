package com.bienvenu.controller;

import com.bienvenu.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bienvenu.service.EventService;

@Controller
@RequestMapping("/event/")
public class EventController {
    
    @Autowired
    public EventService eventService;

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
}
