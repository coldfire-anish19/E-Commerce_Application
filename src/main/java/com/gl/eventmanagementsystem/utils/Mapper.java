package com.gl.eventmanagementsystem.utils;

import com.gl.eventmanagementsystem.EventManagementSystemApplication;
import com.gl.eventmanagementsystem.dto.EventDto;
import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.entity.Event;
import com.gl.eventmanagementsystem.entity.Registration;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
public class Mapper {
    // It is a method that maps an Event object to an EventDto object.
    public static EventDto mapToEventDto(Event event){
        return EventManagementSystemApplication.modelMapper().map(event,EventDto.class);
    }

    // It is a method that maps an EventDto object to an Event object.
    public static Event mapToEvent(EventDto eventDto){
        return EventManagementSystemApplication.modelMapper().map(eventDto, Event.class);
    }

    // It is a method that maps an Registration object to a RegistrationDto object.
    public static RegistrationDto mapToRegistrationDto(Registration registration){
        return EventManagementSystemApplication.modelMapper().map(registration, RegistrationDto.class);
    }

    // It is a method that maps a RegistrationDto object to a Registration object.
    public static Registration mapToRegistration(RegistrationDto registrationDto){
        return EventManagementSystemApplication.modelMapper().map(registrationDto, Registration.class);
    }
}
