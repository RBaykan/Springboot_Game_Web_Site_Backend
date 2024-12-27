package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
