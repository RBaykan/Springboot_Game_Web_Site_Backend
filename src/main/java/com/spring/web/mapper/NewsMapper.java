package com.spring.web.mapper;

import com.spring.web.entity.News;
import com.spring.web.entityDTO.NewsDTO;

public class NewsMapper {
	
	public static News DTO_to_model(NewsDTO dto) {
		
		return News.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.content(dto.getContent())
					.date(dto.getDate())
					.picture(dto.getPicture())
				.build();
	}
	
	
	public static NewsDTO model_to_DTO(News news) {
		
		return NewsDTO.builder()
				.id(news.getId())
				.title(news.getTitle())
				.content(news.getContent())
				.date(news.getDate())
				.picture(news.getPicture())
				.build();
	}

}
