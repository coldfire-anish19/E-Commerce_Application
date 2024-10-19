package com.gl.eventmanagementsystem.repository;

import com.gl.eventmanagementsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into an event repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
