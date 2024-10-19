package com.gl.eventmanagementsystem.repository;

import com.gl.eventmanagementsystem.entity.Registration;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a registration repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>  {
    // create a method to check if a user exists by email
    Registration findByEmail(String email);
}
