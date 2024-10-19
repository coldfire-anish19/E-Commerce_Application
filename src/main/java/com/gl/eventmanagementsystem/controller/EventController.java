package com.gl.eventmanagementsystem.controller;

import com.gl.eventmanagementsystem.dto.EventDto;
import com.gl.eventmanagementsystem.service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Add the required annotations to make this class a REST Controller
    for handling the event related requests.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/events")
public class EventController {
EventService eventService;
    // Add an event
    @PostMapping
    EventDto createEvent(@RequestBody @Valid EventDto eventDto){
        return eventService.createEvent(eventDto);
    }

    // Get all events
    @GetMapping
    List<EventDto> getAllEvents(){
        return eventService.getAllEvents();
    }
    // Get an event by ID
    @GetMapping("/{eventId}")
    EventDto getEvent(@PathVariable Long eventId){
      return eventService.getEvent(eventId);
    }

    // Cancel an event
    @DeleteMapping("/{eventId}")
    String cancelEvent(@PathVariable Long eventId){
        eventService.cancelEvent(eventId);
        return "Event cancelled successfully";
    }
}
