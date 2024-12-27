package com.spring.web.mapper;


import com.spring.web.entity.Map;
import com.spring.web.entityDTO.MapDTO;


public class MapMapper {
	
	public static Map DTO_to_model(MapDTO dto) {
		
		return Map.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.content(dto.getContent())
					.date(dto.getDate())
					.picture(dto.getPicture())
				.build();
	}
	
	
	public static MapDTO model_to_DTO(Map model) {
		
		return MapDTO.builder()
				.id(model.getId())
				.title(model.getTitle())
				.content(model.getContent())
				.date(model.getDate())
				.picture(model.getPicture())
				.build();
	}

}
