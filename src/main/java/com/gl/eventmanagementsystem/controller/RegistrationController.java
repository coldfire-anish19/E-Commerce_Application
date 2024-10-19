package com.gl.eventmanagementsystem.controller;

import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.repository.RegistrationRepository;
import com.gl.eventmanagementsystem.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
    Add the required annotations to make this class a REST Controller
    for handling the registration related requests.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/events/register")
public class RegistrationController {
    RegistrationService registrationService;

    // Add a registration
    @PostMapping
   public RegistrationDto register(@RequestBody @Valid RegistrationDto registrationDto){
        return registrationService.register(registrationDto);
    }

    // Get the registration status
    @GetMapping("/status/{regId}/{eventId}")
    public RegistrationDto getRegistrationStatus(@PathVariable Long eventId,@PathVariable Long regId){
       return registrationService.getRegistrationStatus(eventId,regId);
    }

    // Delete a registration
    @DeleteMapping("/cancel/{eventId}/{regId}")
    public String deleteRegistration(@PathVariable Long eventId, @PathVariable Long regId){
       registrationService.deleteRegistration(eventId,regId);
       return "Registration cancelled successfully";
    }

}
