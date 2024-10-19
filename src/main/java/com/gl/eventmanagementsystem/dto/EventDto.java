package com.gl.eventmanagementsystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * event name should not be null and should have a minimum of 3 characters
      * event date should not be null
      * location should not be null and should have a minimum of 3 characters
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    @Size(min = 3,message = "Event name should have minimum 3 characters")
    @NotEmpty(message = "must not be empty")
    private String eventName;
    @NotEmpty(message = "must not be empty")
    private String eventDate;
    @Size(min = 3,message = "Location should have minimum 3 characters")
    private String location;
    private List<RegistrationDto> registrations;
}
