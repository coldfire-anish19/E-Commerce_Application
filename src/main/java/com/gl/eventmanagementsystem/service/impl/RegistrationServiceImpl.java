package com.gl.eventmanagementsystem.service.impl;

import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.entity.Event;
import com.gl.eventmanagementsystem.entity.Registration;
import com.gl.eventmanagementsystem.entity.RegistrationStatus;
import com.gl.eventmanagementsystem.exception.EMSApiException;
import com.gl.eventmanagementsystem.exception.ResourceNotFoundException;
import com.gl.eventmanagementsystem.repository.EventRepository;
import com.gl.eventmanagementsystem.repository.RegistrationRepository;
import com.gl.eventmanagementsystem.service.RegistrationService;
import com.gl.eventmanagementsystem.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
EventRepository eventRepository;
RegistrationRepository registrationRepository;
    @Override
    public RegistrationDto register(RegistrationDto registrationDto) {
        Event event = eventRepository.findById(registrationDto.getEventId()).orElseThrow(()->new ResourceNotFoundException("Event","Id",registrationDto.getEventId()));
        registrationDto.setStatus(RegistrationStatus.CONFIRMED);
        Registration registration = registrationRepository.save(Mapper.mapToRegistration(registrationDto));
        return Mapper.mapToRegistrationDto(registration);
    }

    @Override
    public RegistrationDto getRegistrationStatus(Long eventId, Long regId) {
        Event event = eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("Event","Id",eventId));
        Registration registration = registrationRepository.findById(regId).orElseThrow(()->new ResourceNotFoundException("Registration","Id",regId));
        if (registration.getEvent().getId()!=event.getId()){
            throw new EMSApiException(HttpStatus.NOT_FOUND,"Registration not found with Id::"+regId+" for the event Id::"+eventId);
        }

        return Mapper.mapToRegistrationDto(registration);
    }

    @Override
    public void deleteRegistration(Long eventId, Long regId) {
        Event event = eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("Event","Id",eventId));
        Registration registration = registrationRepository.findById(regId).orElseThrow(()->new ResourceNotFoundException("Registration","Id",regId));
        if (registration.getEvent().getId()!=event.getId()){
            throw new EMSApiException(HttpStatus.NOT_FOUND,"Registration not found with Id::"+regId+" for the event Id::"+eventId);
        }
        registrationRepository.delete(registration);
    }
}
