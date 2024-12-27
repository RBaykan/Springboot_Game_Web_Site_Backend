package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.spring.web.entityDTO.EventDTO;


@Service
public interface EventService {

	EventDTO getModel(Long id);
	
	List<EventDTO> getAll(); 
	
	EventDTO createModel(EventDTO modelDTO);
	
	void delete(Long id);
	
	EventDTO updateModel(Long id, EventDTO modelDTO);
	
	
}
