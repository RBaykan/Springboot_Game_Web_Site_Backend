package com.spring.web.mapper;


import com.spring.web.entity.Event;
import com.spring.web.entityDTO.EventDTO;

public class EventMapper {
	
	public static Event DTO_to_model(EventDTO dto) {
		
		return Event.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.content(dto.getContent())
					.date(dto.getDate())
					.picture(dto.getPicture())
				.build();
	}
	
	
	public static EventDTO model_to_DTO(Event model) {
		
		return EventDTO.builder()
				.id(model.getId())
				.title(model.getTitle())
				.content(model.getContent())
				.date(model.getDate())
				.picture(model.getPicture())
				.build();
	}

}
