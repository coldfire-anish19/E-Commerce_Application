package com.gl.eventmanagementsystem.service;

import com.gl.eventmanagementsystem.dto.EventDto;

import java.util.List;

public interface EventService {
    // It is responsible for creating an event.
    EventDto createEvent(EventDto eventDto);
    // It is responsible for getting the event from the database using the eventId.
    EventDto getEvent(Long eventId);
    // It is responsible for getting all the events from the database.
    List<EventDto> getAllEvents();
    // It is responsible for updating the event in the database.
    void cancelEvent(Long eventId);
}
