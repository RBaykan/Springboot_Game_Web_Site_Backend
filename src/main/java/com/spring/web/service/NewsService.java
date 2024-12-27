package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.entityDTO.NewsDTO;

@Service
public interface NewsService {

	NewsDTO getNews(Long id);
	
	List<NewsDTO> getAll(); 
	
	NewsDTO createNews(NewsDTO newsDTO);
	
	void delete(Long id);
	
	NewsDTO updateNews(Long id, NewsDTO newsDTO);
	
	
}
