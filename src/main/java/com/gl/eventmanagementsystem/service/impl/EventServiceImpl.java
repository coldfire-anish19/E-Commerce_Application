package com.gl.eventmanagementsystem.service.impl;


import com.gl.eventmanagementsystem.dto.EventDto;
import com.gl.eventmanagementsystem.entity.Event;
import com.gl.eventmanagementsystem.exception.ResourceNotFoundException;
import com.gl.eventmanagementsystem.repository.EventRepository;
import com.gl.eventmanagementsystem.service.EventService;
import com.gl.eventmanagementsystem.utils.Mapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    EventRepository eventRepository;
    @Override
    public EventDto createEvent(EventDto eventDto) {
        return Mapper.mapToEventDto(eventRepository.save(Mapper.mapToEvent(eventDto)));
    }

    @Override
    public EventDto getEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("Event","Id",eventId));
        return Mapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(Mapper::mapToEventDto).toList();
    }

    @Override
    public void cancelEvent(Long eventId) {
     Event event = eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("Event","Id",eventId));
     eventRepository.delete(event);
    }
}
