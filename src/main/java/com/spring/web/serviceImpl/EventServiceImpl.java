package com.spring.web.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.spring.web.entity.Event;

import com.spring.web.entityDTO.EventDTO;

import com.spring.web.exception.EventNotFound;

import com.spring.web.mapper.EventMapper;

import com.spring.web.repository.EventRepository;

import com.spring.web.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	

	private final EventRepository repository;
	
	public EventServiceImpl(EventRepository repository) {
		
		this.repository = repository;
	
}

	
	@Override
	public EventDTO getModel(Long id) {
		Event model = repository.findById(id).orElseThrow(() -> new EventNotFound("Not found"));
		
		
		return EventMapper.model_to_DTO(model);
	}


	@Override
	public List<EventDTO> getAll() {

		List<Event> models = repository.findAll();
		

		// TODO Auto-generated method stub
		return models.stream().map(
			
			(model) -> EventMapper.model_to_DTO(model)

		).collect(Collectors.toList());
	}
	
	@Override
	public EventDTO createModel(EventDTO modelDTO) {
		// TODO Auto-generated method stub
		Event model = EventMapper.DTO_to_model(modelDTO);
		model.setDate(LocalDate.now());
		
		Event saved = repository.save(model);
		
		return EventMapper.model_to_DTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		Event model = repository.findById(id).orElseThrow(() -> new EventNotFound("Not found"));
		repository.delete(model);
	}
	
	
	@Override
	public EventDTO updateModel(Long id, EventDTO modelDTO) {
		Event model = repository.findById(id).orElseThrow(
				() -> new EventNotFound("Not found content by id: " + id)
				);
		
		model.setTitle(modelDTO.getTitle());
		model.setContent(modelDTO.getContent());
		model.setPicture(modelDTO.getPicture());
		
	
	
		Event saved = repository.save(model);
		
		
		
		return EventMapper.model_to_DTO(saved);
	}
}
